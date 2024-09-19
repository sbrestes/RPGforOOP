import java.util.ArrayList;
public class LightningStrikeMove extends Move {
    @Override
    public String getTitle() {
        return "Lightning Strike";
    }

    @Override
    public ArrayList<Command> use(Character user, Character receiver) {
        ArrayList<Command> commands = new ArrayList<>();
        commands.add(new Command() {
            @Override
            public void perform(Scene scene) {
                int damage = 50; // Heavy damage
                scene.displayMessage(user.getName() + " uses Lightning Strike! It deals " + damage + " damage to " + receiver.getName() + ", but costs some HP.");
                receiver.dealDamage(damage);
                user.dealDamage((int) (user.getMaxHP() * 0.10)); // 10% recoil damage
            }
        });
        return commands;
    }
}