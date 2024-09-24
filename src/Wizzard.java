import java.util.ArrayList;

public class Wizzard extends Character {
    public Equipment weapon;
    public Equipment armor;

    public Wizzard(Behavior behavior, String name, int maxHP) {
        super(behavior, name, maxHP);
    }

    public int dealDamage(int amount) {
       if(isMultiply() == true) {
           amount = amount * 2;
       }
        int newAmount = amount;
        if (armor != null) {
            newAmount = armor.adjustDefense(amount);
        }
        setHp(getHp() - newAmount);
        return newAmount;
    }

    public ArrayList<Move> getMoves() {
        ArrayList<Move> moves = new ArrayList<Move>();
        moves.add(new NormalAttackMove());
        moves.add(new MagicAttackMove());
        return moves;
    }
}
