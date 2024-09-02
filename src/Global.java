public class Global {
    private static Global instance = null;

    private int totalDamage;

    private Global() {
        totalDamage = 0;
    }

    public static Global getInstance()
    {
        if (instance == null)
            instance = new Global();

        return instance;
    }

    public void reportDamage(int amount) {
        totalDamage += amount;
    }

    public int getTotalDamage() {
        return totalDamage;
    }
}
