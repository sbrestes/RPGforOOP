import java.util.ArrayList;

public class Beast extends Character {

    /*
    unstoppable
     */

    public Equipment weapon;
    public Equipment armor;

    public Beast(String name, Equipment weapon, Equipment armor) {
        super(name, 0x100);
        this.weapon = weapon;
        this.armor = armor;
    }

    public int getAttackPower() {
        int amount = 443;
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
        hp -= newAmount;
        return newAmount;
    }

    public ArrayList<Move> getMoves() {
        ArrayList<Move> moves = new ArrayList<>();
        moves.add(new MultiAttackMove(100000));
        return moves;
    }
}
