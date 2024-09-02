import java.util.ArrayList;

public abstract class Character {
    public String name;
    public int maxHP;
    public int hp;

    public Character(String name, int maxHP) {
        this.name = name;
        this.maxHP = maxHP;
        this.hp = maxHP;
    }

    public String getName() {
        return name;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getHP() {
        return hp;
    }

    public abstract int getAttackPower();

    public abstract int dealDamage(int amount);

    public abstract ArrayList<Move> getMoves();
}
