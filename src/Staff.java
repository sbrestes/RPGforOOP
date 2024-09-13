public class Staff extends Equipment{
    @Override
    public int adjustAttack(int amount) {
        return amount + 1;
    }
}
