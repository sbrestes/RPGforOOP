public class LeatherArmor extends Equipment{

    @Override
    public int adjustDefense(int amount) {
        return amount - 1;
    }
}
