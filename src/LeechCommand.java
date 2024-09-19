public class LeechCommand extends Command{

    final private int damage;
    final private Character defender;
    final private Character user;

    public LeechCommand(int damage, Character defender, Character user) {
        this.damage = damage;
        this.defender = defender;
        this.user = user;
    }

    public void perform(Scene scene) {
        int actualDealtDamage = defender.dealDamage(damage);
        scene.displayMessage(actualDealtDamage + " damage to " + defender.getName());
        user.setMaxHP(user.getMaxHP() + actualDealtDamage);
        user.setHp(user.getHp() + actualDealtDamage);
        scene.displayMessage("Max HP of " + user.getName() + " has increased by " + actualDealtDamage);
        scene.displayMessage("HP of " + user.getName() + " has been restored by " + actualDealtDamage);

    }
}
