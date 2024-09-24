public class Wand extends Weapon{
    @Override
    public String getTitle() {
        return "Wand";
    }

    @Override
    public int adjustAttack(int amount) {
        return amount + 1;
    }
}