public class PoisonEffect implements StatusEffect {
    private int turnsRemaining;

    public PoisonEffect(int turns) {
        this.turnsRemaining = turns; // Set how many turns the poison lasts
    }

    @Override
    public void applyEffect(Character character) {
        if (turnsRemaining > 0) {
            int poisonDamage = 5; // Damage per turn, can be adjusted
            character.dealDamage(poisonDamage);  // Apply poison damage
            System.out.println(character.getName() + " takes " + poisonDamage + " poison damage! (" + turnsRemaining + " turns remaining)");
            turnsRemaining--;
        }
    }

    public int getTurnsRemaining() {
        return turnsRemaining;
    }
}
