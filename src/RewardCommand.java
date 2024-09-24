import java.util.ArrayList;

public class RewardCommand extends Command {

    private Character rewarded;
    private int level;

    public RewardCommand(Character rewarded, int level) {
        this.rewarded = rewarded;
        this.level = level;
    }

    @Override
    public void perform(Scene scene) {
        ArrayList<Rewardable> choices = new ArrayList<Rewardable>();
        ArrayList<Move> moves = rewarded.getMoves();
        while(level < moves.size() * 3) {
            moves.remove(moves.size()-1);
        }
        for (Move m : rewarded.getLearnedMoves()) {
            if (moves.contains(m)) {
                moves.remove(m);
            }
        }
        choices.addAll(moves);
        choices.add(new Potion((int)(Math.random() * level * 2)));
        choices.add(new LevelSkip());
        if (level > 15) {
            choices.add(new Potion((int)(Math.random() * level * 3)));
        }
        if (level < 10) {
            choices.add(new Shirt());
        }
        if (level > 5) {
            choices.add(new LeatherArmor());
        }
        if (level > 10) {
            choices.add(new BronzePlate());
        }
        if (level > 25) {
            choices.add(new ChronoRing());
        }
        choices.add(new Staff());
        if (level < 15) {
            choices.add(new Staff());
        }
        if (level > 6) {
            choices.add(new Sword());
        }
        if (level > 12) {
            choices.add(new Mace());
        }
        if (level > 30) {
            choices.add(new EldritchScythe());
        }
        while(choices.size() > 3) {
            choices.remove((int)(Math.random() * choices.size()));
        }
        String[] options = new String[choices.size()];
        scene.displayMessage("Choose your reward!");
        for (int i = 0; i < choices.size(); i++) {
            options[i] = choices.get(i).getTitle();
        }
        scene.displayOptions(options);
        int choice = scene.getIntInput(1, choices.size()+1);
        scene.displayMessage("Obtained " + choices.get(choice-1).getTitle());
        choices.get(choice-1).addToCharacter(rewarded);
    }
}
