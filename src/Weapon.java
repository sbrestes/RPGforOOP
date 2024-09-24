public abstract class Weapon implements Rewardable {
    public abstract String getTitle();

    public int adjustAttack(int amount) {
        return amount;
    }

    public void addToCharacter(Character c) {
        c.setWeapon(this);
    }
}
