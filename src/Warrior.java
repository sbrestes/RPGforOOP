import java.util.ArrayList;

public class Warrior extends Character {
    public Equipment weapon;
    public Equipment armor;

    public Warrior(String name, int maxHP, Equipment weapon, Equipment armor) {
        super(name, maxHP);
        this.weapon = weapon;
        this.armor = armor;
    }

    public int getAttackPower() {
        int amount = 2;
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
        moves.add(new MultiAttackMove(3));
        moves.add(new MagicDust(1));
        moves.add(new SurrenderMove());
        moves.add(new FreezeMove());
        moves.add(new HealMove());
        moves.add(new PoisonMove());
        moves.add(new ShieldMove());
        moves.add(new LightningStrikeMove());
        moves.add(new HelloWorldMove());
        return moves;
    }
}
