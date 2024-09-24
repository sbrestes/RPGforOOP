import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Scene {
    private Character player;
    private Character opponent;
    CharacterFactory opponentFact;
    private boolean gameOver = false;
    private ArrayList<Command> commandQueue = new ArrayList<Command>();
    Scanner scanner;

    public Scene() {
        this.player = null;
        this.opponent = null;
        scanner = new Scanner(System.in);
    }

    public Scene(Character player, Character opponent) {
        this.player = player;
        this.opponent = opponent;
        scanner = new Scanner(System.in);
    }

    public Character getPlayer() {
        return player;
    }

    public Character getOpponent() {
        return opponent;
    }

    public void setPlayer(Character player) {
        this.player = player;
    }

    public void setOpponent(Character opponent) {
        this.opponent = opponent;
    }

    public void displayMessage(String output) {
        displayMessage(output, true);
    }

    public void displayMessage(String output, boolean doPause) {
        System.out.println("|    * " + String.format("%-54s", output) + "|");
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
        }
    }

    public void displayOptions(String[] output) {
        for (int i = 0; i < output.length; i++) {
            System.out.println("|         " + String.format("%4s", (i+1) + ". ") + String.format("%-47s", output[i]) + "|");
        }
    }

    public void waitForEnter() {
        scanner.nextLine();
    }

    public String getStringInput(){
        System.out.print("       > ");
        return scanner.nextLine();
    }

    public int getIntInput() {
        return getIntInput(0, Integer.MAX_VALUE);
    }

    public int getIntInput(int maxExclusive) {
        return getIntInput(0, maxExclusive);
    }

    public int getIntInput(int minInclusive, int maxExclusive) {
        System.out.print("       > ");
        int ret = -1;
        boolean done = false;
        while(!done) {
            if (scanner.hasNextInt()) {
                ret = scanner.nextInt();
                if (ret >= minInclusive && ret < maxExclusive) {
                    done = true;
                    scanner.nextLine();
                } else {
                    displayMessage(ret + " is outside the range " + minInclusive + " <= x < " + maxExclusive, false);
                    System.out.print("       > ");
                }
            } else {
                displayMessage(scanner.nextLine() + " is not a valid integer.", false);
                System.out.print("       > ");
            }
        }
        return ret;
    }

    public void displayStats() {
        System.out.println("==============================================================");
        System.out.println("|     " + String.format("%-25s", player.displayHP()) + String.format("%25s", opponent.displayHP()) + "     |");
        System.out.println("|     " + makeProgBar(player.getHp(), player.getMaxHP(), 15, false) + "                    " + makeProgBar(opponent.getHp(), opponent.getMaxHP(), 15, true) + "     |");
        System.out.println("|     " + String.format("%-25s", player.displayMP()) + String.format("%25s", opponent.displayMP()) + "     |");
        System.out.println("|     " + makeProgBar(player.getMp(), player.getMaxMP(), 15, false) + "                    " + makeProgBar(opponent.getMp(), opponent.getMaxMP(), 15, true) + "     |");
        System.out.println("|     " + String.format("%-25s", player.displayWeapon()) + String.format("%25s", opponent.displayWeapon()));
        System.out.println("|     " + String.format("%-25s", player.displayArmor()) + String.format("%25s", opponent.displayArmor()));

        System.out.println("|                                                            |");
        System.out.println("|                         Level: " + String.format("%3s", Global.getInstance().getLevel()) + "                         |");
        String[] pf = player.displayFigure();
        String[] of = player.displayFigure();

        for (int i = 0; i < pf.length; i++) {
            System.out.println("|            " + pf[i] + "                      " + of[i] + "            |");
        }
        System.out.println("|  " + String.format("%-28s", player.getName()) + String.format("%28s", opponent.getName()) + "  |");

        System.out.println("|                                                            |");
    }

    public String makeProgBar(int num, int denom, int length, boolean flip) {
        String ret = "";
        if (length <= 0 || denom <= 0 || num <= 0) {
            for (int i = 0; i < length; i++) {
                ret += " ";
            }
        } else {
            int unit = denom / length;
            int prog = length * num / denom;
            if (flip) {
                for (int i = 0; i < length - prog; i++) {
                    ret += "-";
                }
            }
            for (int i = 0; i < prog; i++) {
                ret += "█";
            }
            if (!flip) {
                for (int i = 0; i < length - prog; i++) {
                    ret += "-";
                }
            }
        }
        return ret;
    }

    public void displayStrength() {
        displayMessage(player.getName() + " Strength: " + player.getMp());
        displayMessage(opponent.getName() + " Strength: " + opponent.getMp());
    }

    public void checkForFightOver() {
        if (player.getHp() <= 0) {
            displayMessage(opponent.getName() + " wins!");
            gameOver = true;
        } else if (opponent.getHp() <= 0) {
            commandQueue.clear();
            displayStats();
            displayMessage(player.getName() + " wins!");
            Global.getInstance().levelUp();
            player.levelUp(this);
            new RewardCommand(player, Global.getInstance().getLevel()).perform(this);
            newOpponent();
            displayStats();

        }
    }

    public void addCommands(ArrayList<Command> commands) {
        commandQueue.addAll(commands);
    }

    public void newOpponent() {
        opponent = opponentFact.build(this);
    }

    public static void main(String[] args) {

        Scene theScene = new Scene();

        CharacterFactory playerFact = new PlayerCharacterFactory();
        theScene.opponentFact = new OpponentCharacterFactory();

        theScene.setPlayer(playerFact.build(theScene));

        theScene.newOpponent();


        theScene.displayStats();
        while (!theScene.gameOver) {

            theScene.commandQueue.addAll(theScene.getPlayer().takeTurn(theScene).use(theScene.player, theScene.opponent));

            theScene.commandQueue.addAll(theScene.getOpponent().takeTurn(theScene).use(theScene.opponent, theScene.player));

            theScene.commandQueue.add(new ProcessStatusEffectsCommand(theScene.getPlayer()));
            theScene.commandQueue.add(new ProcessStatusEffectsCommand(theScene.getOpponent()));
            theScene.commandQueue.add(new CheckFightOverCommand());
            theScene.commandQueue.add(new DisplayStatsCommand());

            while (!theScene.commandQueue.isEmpty() && !theScene.gameOver) {
                theScene.commandQueue.get(0).perform(theScene);
                if (theScene.commandQueue.size() > 0)
                    theScene.commandQueue.remove(0);
            }
        }

        new DisplayStatsCommand().perform(theScene);

        theScene.displayMessage("Game over. Total damage dealt: " + Global.getInstance().getTotalDamage());

        theScene.scanner.close();
    }
}
