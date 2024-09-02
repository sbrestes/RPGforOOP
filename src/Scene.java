import java.util.ArrayList;
import java.util.Scanner;

public class Scene {
    private Character player;
    private Character opponent;
    private boolean gameOver = false;
    private ArrayList<Command> commandQueue = new ArrayList<Command>();

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
        Scanner scanner = new Scanner(System.in);

        Scene theScene = new Scene(
                new Warrior("The Player", 10, new Sword(), new BronzePlate()),
                new Warrior("The Other Guy", 10, null, new Shirt())
        );

        theScene.displayStats();
        while (!theScene.gameOver) {
            System.out.println("What will you do?");
            ArrayList<Move> options = theScene.getPlayer().getMoves();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i+1) + ": " + options.get(i).getTitle());
            }
            int choice = scanner.nextInt();
            scanner.nextLine();

            theScene.commandQueue.addAll(options.get(choice-1).use(theScene.player, theScene.opponent));

            ArrayList<Move> opponentOptions = theScene.getOpponent().getMoves();
            int opponentChoice = (int)(Math.random() * opponentOptions.size());
            theScene.commandQueue.addAll(options.get(opponentChoice).use(theScene.opponent, theScene.player));

            while (!theScene.commandQueue.isEmpty() && !theScene.gameOver) {
                theScene.commandQueue.get(0).perform(theScene);
                theScene.commandQueue.remove(0);
            }
        }

        System.out.println("Game over. Total damage dealt: " + Global.getInstance().getTotalDamage());

        scanner.close();
    }
}
