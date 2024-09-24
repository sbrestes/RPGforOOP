public class Sword extends Weapon{
    @Override
    public String getTitle() {
        return "Sword";
    }

    @Override
    public int adjustAttack(int amount) {
        return amount + 4;
    }
}
