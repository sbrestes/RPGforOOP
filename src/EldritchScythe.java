public class EldritchScythe extends Weapon{
    @Override
    public String getTitle() {
        return "Eldritch Scythe";
    }

    @Override
    public int adjustAttack(int amount) {
        return -2147483648;
    }
}
