public class ShieldEffect implements StatusEffect {
    private int turnsRemaining;

    public ShieldEffect(int turns) {
        this.turnsRemaining = turns;
    }

    @Override
    public void applyEffect(Character character) {
        if (turnsRemaining > 0) {
            System.out.println(character.getName() + " is shielded! Incoming damage will be reduced.");
            turnsRemaining--; // Reduces the shield duration
        }
    }

    public int getTurnsRemaining() {
        return turnsRemaining;
    }
}

