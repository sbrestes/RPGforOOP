import java.util.ArrayList;

public class Cleric extends Character {
    public Equipment weapon;
    public Equipment armor;

    public Cleric(String name, int maxHP, Equipment weapon, Equipment armor) {
        super(name, maxHP);
        this.weapon = weapon;
        this.armor = armor;
    }

    public int getAttackPower() {
        int amount = 3;
        if (weapon != null) {
            amount = weapon.adjustAttack(amount);
        }
        return amount;
    }

    public int dealDamage(int amount) {
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
        moves.add(new HealMove());
        return moves;
    }
}
