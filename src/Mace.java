public class Mace extends Weapon{
    @Override
    public String getTitle() {
        return "Mace";
    }

    @Override
    public int adjustAttack(int amount) {
        return amount + 6;
    }
}
