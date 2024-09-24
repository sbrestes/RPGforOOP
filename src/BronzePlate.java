public class BronzePlate extends Equipment{

    @Override
    public String getTitle() {
        return "Bronze Plate";
    }

    @Override
    public int adjustDefense(int amount) {
        return amount - 2;
    }
}
