public class LeatherArmor extends Equipment{

    @Override
    public String getTitle() {
        return "Leather Armor";
    }

    @Override
    public int adjustDefense(int amount) {
        return amount - 1;
    }
}
