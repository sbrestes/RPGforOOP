import java.util.ArrayList;

public class Wizzard extends Character {
    public Equipment weapon;
    public Equipment armor;

    public Wizzard(String name, int maxHP, Equipment weapon, Equipment armor) {
        super(name, maxHP);
        this.weapon = weapon;
        this.armor = armor;
    }

    public int getAttackPower() {
        int num = (int) (Math.random() * 100);
        int amount = 2;
        if (weapon != null) {
            amount = weapon.adjustAttack(amount);
        }
        return amount;
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
