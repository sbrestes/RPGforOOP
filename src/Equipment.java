public abstract class Equipment implements Rewardable{
    public abstract String getTitle();

    public int adjustDefense(int amount) {
        return amount;
    }

    public int adjustDefense(int amount, int maxHp) {
        return amount;
    }

    public void addToCharacter(Character c) {
        c.setEquipment(this);
    }
}
