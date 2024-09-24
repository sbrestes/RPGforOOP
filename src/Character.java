import java.util.ArrayList;

public abstract class Character {
    private String name;
    private int maxHP;
    private int hp;
    private int maxMP;
    private int mp;

    private double critChance = 0.1;
    private int critDmg = 5;

    private Weapon weapon;
    private Equipment armor;

    private ArrayList<Move> moves;

    private Behavior behavior;

    private boolean isFrozen = false;
    private boolean isMultiply = false;// Track if character is frozen
    private ArrayList<StatusEffect> statusEffects = new ArrayList<>(); // Active status effects

    public Character(Behavior behavior, String name, int maxHP) {
        this.behavior = behavior;
        this.name = name;
        this.maxHP = maxHP;
        this.hp = maxHP;
        this.maxMP = 0;
        this.mp = 0;
        this.weapon = null;
        this.armor = null;
        moves = behavior.getStarterMoves(this);
    }
    public Character(String name, int maxHP, double critChance, int critDmg) {
        this.name = name;
        this.maxHP = maxHP;
        this.hp = maxHP;
        this.maxMP = 0;
        this.mp = 0;
        this.critChance=critChance;
        this.critDmg=critDmg;
    }

    public Character(Behavior behavior, String name, int maxHP, int maxMP) {
        this.behavior = behavior;
        this.name = name;
        this.maxHP = maxHP;
        this.hp = maxHP;
        this.maxMP = maxMP;
        this.mp = maxMP;
        this.weapon = null;
        this.armor = null;
        moves = behavior.getStarterMoves(this);
    }

    public void levelUp(Scene scene) {
        int hpUp = (int)(Math.random() * 3) + 1;
        scene.displayMessage("Level up! Max HP went up by " + hpUp);
        maxHP += hpUp;
        hp += hpUp;
    }

    public String displayHP() {
        return "Health: " + getHp() + "/" + getMaxHP();
    }

    public String displayMP() {
        if (getMaxMP() <= 0) {
            return "";
        }
        return "Magic : " + getMp() + "/" + getMaxMP();
    }

    public String[] displayFigure() {
        String[] ret = {
                "   o   ",
                "  /|\\  ",
                "   |   ",
                "  / \\  "
        };
        return ret;
    }

    public String displayWeapon() {
        if (weapon == null) {
            return "";
        } else {
            return weapon.getTitle();
        }
    }

    public String displayArmor() {
        if (armor == null) {
            return "";
        } else {
            return armor.getTitle();
        }
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
        if (this.hp > this.maxHP) {
            this.hp = this.maxHP;
        }
    }

    public int getMaxMP() {
        return maxMP;
    }

    public void setMaxMP(int maxMP) {
        this.maxMP = maxMP;
        if (this.mp > this.maxMP) {
            this.mp = this.maxMP;
        }
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
        if (this.mp > maxMP) {
            this.mp = maxMP;
        }
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Equipment getArmor() {
        return armor;
    }

    public void setEquipment(Equipment armor) {
        this.armor = armor;
    }

    public double getcritChance()
    {
        return critChance;
    }

    public void setcritChance(double critChance)
    {
        this.critChance=critChance;
    }

    public int getcritDmg()
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

    // Methods for freezing
    public boolean isFrozen() {
        return isFrozen;
    }
    public boolean isMultiply() {
        return isMultiply;
    }



    public void setFrozen(boolean frozen) {
        isFrozen = frozen;
    }

    public void setMultiply(boolean multiply){
        isMultiply = multiply;
    }

    // Method to apply a status effect (like Poison, Shield)
    public void applyStatusEffect(StatusEffect effect) {
        statusEffects.add(effect);
    }

    // Process and apply all active status effects
    public void processStatusEffects(Scene scene) {
        ArrayList<StatusEffect> toRemove = new ArrayList<>();
        for (StatusEffect effect : statusEffects) {
            effect.applyEffect(scene, this);
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

    // Get the list of available moves (must be implemented by subclasses)
    public abstract ArrayList<Move> getMoves();

    public ArrayList<Move> getLearnedMoves() {
        return moves;
    }

    public void learnMove(Move move) {
        moves.add(move);
    }
}