import java.util.ArrayList;
import java.util.Scanner;

public class Scene {
    private Character player;
    private Character opponent;
    private boolean gameOver = false;
    private ArrayList<Command> commandQueue = new ArrayList<Command>();
    Scanner scanner;

    public Scene(Character player, Character opponent) {
        this.player = player;
        this.opponent = opponent;
    }

    public Character getPlayer() {
        return player;
    }

    public Character getOpponent() {
        return opponent;
    }

    public void displayMessage(String output) {
        System.out.println(output);
    }

    public String getStringInput(){
        return scanner.nextLine();
    }

    public int getIntInput() {
        return getIntInput(0, Integer.MAX_VALUE);
    }

    public int getIntInput(int maxExclusive) {
        return getIntInput(0, maxExclusive);
    }

    public int getIntInput(int minInclusive, int maxExclusive) {
        int ret = -1;
        boolean done = false;
        while(!done) {
            if (scanner.hasNextInt()) {
                ret = scanner.nextInt();
                if (ret >= minInclusive && ret < maxExclusive) {
                    done = true;
                } else {
                    displayMessage(ret + " is outside the range " + minInclusive + " <= x < " + maxExclusive);
                }
            } else {
                displayMessage(scanner.nextLine() + " is not a valid integer.");
            }
        }
        return ret;
    }

    public void displayStats() {
        System.out.println(player.getName() + " HP: " + player.getHP() + "/" + player.getMaxHP());
        System.out.println(opponent.getName() + " HP: " + opponent.getHP() + "/" + opponent.getMaxHP());
    }

    public void checkForGameOver() {
        if (player.getHP() <= 0) {
            System.out.println(opponent.getName() + " wins!");
            gameOver = true;
        } else if (opponent.getHP() <= 0) {
            System.out.println(player.getName() + " wins!");
            gameOver = true;
        }
    }

    public static void main(String[] args) {

        Scene theScene = new Scene(
                new Warrior("The Player", 10, new Sword(), new BronzePlate()),
                new Warrior("The Other Guy", 10, null, new Shirt())
        );
        theScene.scanner = new Scanner(System.in);

        theScene.displayStats();
        while (!theScene.gameOver) {
            theScene.displayMessage("What will you do?");
            ArrayList<Move> options = theScene.getPlayer().getMoves();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i+1) + ": " + options.get(i).getTitle());
            }
            int choice = theScene.getIntInput(1, options.size() + 1) - 1;
            theScene.scanner.nextLine();

            theScene.commandQueue.addAll(options.get(choice).use(theScene.player, theScene.opponent));

            ArrayList<Move> opponentOptions = theScene.getOpponent().getMoves();
            int opponentChoice = (int)(Math.random() * opponentOptions.size());
            theScene.commandQueue.addAll(opponentOptions.get(opponentChoice).use(theScene.opponent, theScene.player));

            while (!theScene.commandQueue.isEmpty() && !theScene.gameOver) {
                theScene.commandQueue.get(0).perform(theScene);
                theScene.commandQueue.remove(0);
            }
        }

        theScene.displayMessage("Game over. Total damage dealt: " + Global.getInstance().getTotalDamage());

        theScene.scanner.close();
    }
}
