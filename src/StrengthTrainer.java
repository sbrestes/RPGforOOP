import java.util.ArrayList;

public class StrengthTrainer extends Character {
    public StrengthTrainer(Behavior behavior, String name, int maxHP) {
        super(behavior, name, maxHP);
        setMaxMP(20);
    }
    public int getAttackPower() {
        return (2 + getMp());
    }

    public String displayMP() {
        if (getMaxMP() <= 0) {
            return "";
        }
        return "Strength : " + getMp();
    }

    public ArrayList<Move> getMoves() {
        ArrayList<Move> moves = new ArrayList<Move>();
        moves.add(new NormalAttackMove());
        moves.add(new TrainMove());
        moves.add(new MultiAttackMove(getMp()));
        moves.add(new LightningStrikeMove());
        return moves;
    }
}
