public class Potion implements Rewardable {

    private int strength;

    public Potion(int strength) {
        this.strength = strength;
    }

    @Override
    public String getTitle() {
        if (strength < 15) {
            return "Potion";
        } else if (strength < 30) {
            return "Super Potion!";
        } else {
            return "Amazing Potion!!";
        }
    }

    @Override
    public void addToCharacter(Character c) {
        c.setHp(c.getHp() + strength);
    }
}
