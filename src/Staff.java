public class Staff extends Weapon{
    @Override
    public String getTitle() {
        return "Staff";
    }

    @Override
    public int adjustAttack(int amount) {
        return amount + 2;
    }
}
