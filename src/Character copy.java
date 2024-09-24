import java.util.ArrayList;

public abstract class Character {
    public String name;
    public int maxHP;
    public int hp;
    public int maxMP;
    public int mp;
    public double critChance;
    public int critDmg;

    Behavior behavior;

    public Character(String name, int maxHP) {
        this.name = name;
        this.maxHP = maxHP;
        this.hp = maxHP;
        this.maxMP = 0;
        this.mp = 0;
        this.critChance=0;
        this.critDmg=0;
    }

    public Character(String name, int maxHP, int maxMP) {
        this.name = name;
        this.maxHP = maxHP;
        this.hp = maxHP;
        this.maxMP = maxMP;
        this.mp = maxMP;
        this.critChance=0;
        this.critDmg=0;
    }

    public Character(String name, int maxHP, double critChance, int critDmg)
    {
        this.name=name;
        this.maxHP=maxHP;
        this.hp=maxHP;
        this.maxMP=0;
        this.mp=0;
        this.critChance=critChance;
        this.critDmg=critDmg;

    }
    public void setBehavior(Behavior behavior) {
        this.behavior = behavior;
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

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.hp = mp;
    }

    public double getcritChance()
    {
        return critChance;
    }

    public void setcritChance(double critChance)
    {
        this.critChance=critChance;
    }

    public int getcritDamg()
    {
        return critDmg;
    }

    public void setcritDmg(int critDmg)
    {
        this.critDmg=critDmg;
    }

    public Move takeTurn(Scene scene){
        return behavior.takeTurn(scene, this);
    }

    public abstract int getAttackPower();

    public abstract int dealDamage(int amount);

    public abstract ArrayList<Move> getMoves();
}
