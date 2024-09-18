import java.util.ArrayList;

public class StrengthTrainer extends Character {
    public Equipment armor;
    public StrengthTrainer(String name, int maxHP, Equipment armor) {
        super(name, maxHP);
        this.mp = 0;
        this.armor = armor;
    }
    public int getAttackPower() {
        return (2 + mp);
    }

    public int dealDamage(int amount) {
        int newAmount = amount;
        if (armor != null) {
            newAmount = armor.adjustDefense(amount);
        }
        hp -= newAmount;
        return newAmount;
    }

    public ArrayList<Move> getMoves() {
        ArrayList<Move> moves = new ArrayList<Move>();
        moves.add(new NormalAttackMove());
        moves.add(new TrainMove());
        return moves;
    }
}
