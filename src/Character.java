import java.util.ArrayList;

public abstract class Character {
    private String name;
    private int maxHP;
    private int hp;
    private int maxMP;
    private int mp;

    private Behavior behavior;

    private boolean isFrozen = false; // Track if character is frozen
    private ArrayList<StatusEffect> statusEffects = new ArrayList<>(); // Active status effects

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

    public int getMaxMP() {
        return maxMP;
    }

    public void setMaxMP(int maxMP) {
        this.maxMP = maxMP;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public Move takeTurn(Scene scene){
        return behavior.takeTurn(scene, this);
    }

    // Methods for freezing
    public boolean isFrozen() {
        return isFrozen;
    }

    public void setFrozen(boolean frozen) {
        isFrozen = frozen;
    }

    // Method to apply a status effect (like Poison, Shield)
    public void applyStatusEffect(StatusEffect effect) {
        statusEffects.add(effect);
    }

    // Process and apply all active status effects
    public void processStatusEffects() {
        ArrayList<StatusEffect> toRemove = new ArrayList<>();
        for (StatusEffect effect : statusEffects) {
            effect.applyEffect(this);
            // Remove the effect if it has expired
            if (effect instanceof PoisonEffect && ((PoisonEffect) effect).getTurnsRemaining() <= 0) {
                toRemove.add(effect);
            }
            if (effect instanceof ShieldEffect && ((ShieldEffect) effect).getTurnsRemaining() <= 0) {
                toRemove.add(effect);
            }
        }
        statusEffects.removeAll(toRemove); // Remove expired effects
    }

    // Heal this character
    public void heal(int amount) {
        this.hp += amount;
        if (this.hp > maxHP) this.hp = maxHP; // Cap healing at max HP
    }

    public abstract int getAttackPower();

    public abstract int dealDamage(int amount);

    // Get the list of available moves (must be implemented by subclasses)
    public abstract ArrayList<Move> getMoves();
}