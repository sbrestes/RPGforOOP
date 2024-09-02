public class AttackCommand extends Command{

    final private int damage;
    final private Character defender;

    public AttackCommand(int damage, Character defender) {
        this.damage = damage;
        this.defender = defender;
    }

    public void perform(Scene scene) {
        int actualDealtDamage = defender.dealDamage(damage);
        scene.displayMessage(actualDealtDamage + " damage to " + defender.getName());
    }
}
