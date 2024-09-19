public class ChronoRing extends Equipment{
    @Override
    public int adjustDefense(int amount, int maxHp) {
        return ((int) Math.ceil((double)amount / (double) maxHp));
    }
}
