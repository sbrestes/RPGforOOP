import java.util.ArrayList;

public class StrengthTrainer extends Character {
    public Equipment armor;
    public StrengthTrainer(String name, int maxHP, Equipment armor) {
        super(name, maxHP);
        this.armor = armor;
    }
    public int getAttackPower() {
        return (2 + getMp());
    }

    public int dealDamage(int amount) {
        int newAmount = amount;
        if (armor != null) {
            newAmount = armor.adjustDefense(amount);
        }
        setHp(getHp()-newAmount);
        return newAmount;
    }

    public ArrayList<Move> getMoves() {
        ArrayList<Move> moves = new ArrayList<Move>();
        moves.add(new NormalAttackMove());
        moves.add(new TrainMove());
        return moves;
    }
}
