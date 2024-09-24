public class Global {
    private static Global instance = null;

    private int level = 1;
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

    public int getLevel() {
        return level;
    }

    public void levelUp() {
        level++;
    }
}
