public class ChronoRing extends Equipment{
    @Override
    public String getTitle() {
        return "Chrono Ring";
    }

    @Override
    public int adjustDefense(int amount, int maxHp) {
        return ((int) Math.ceil((double)amount / (double) maxHp));
    }
}
