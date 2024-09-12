import java.util.ArrayList;

public abstract class Character {
    public String name;
    public int maxHP;
    public int hp;
    public int maxMP;
    public int mp;

    public Character(String name, int maxHP) {
        this.name = name;
        this.maxHP = maxHP;
        this.hp = maxHP;
        this.maxMP = 0;
        this.mp = 0;
    }

    public Character(String name, int maxHP, int maxMP) {
        this.name = name;
        this.maxHP = maxHP;
        this.hp = maxHP;
        this.maxMP = maxMP;
        this.mp = maxMP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public abstract int getAttackPower();

    public abstract int dealDamage(int amount);

    public abstract ArrayList<Move> getMoves();
}
