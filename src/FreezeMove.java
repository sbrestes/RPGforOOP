import java.util.ArrayList;

public class FreezeMove extends Move {
    @Override
    public String getTitle() {
        return "Freeze";
    }

    @Override
    public ArrayList<Command> use(Character user, Character receiver) {
        ArrayList<Command> commands = new ArrayList<>();
        commands.add(new Command() {
            @Override
            public void perform(Scene scene) {
                scene.displayMessage(user.getName() + " uses Freeze on " + receiver.getName() + "!");
                receiver.setFrozen(true);  // Ensure `setFrozen()` exists in `Character`
                receiver.dealDamage(10);   // Apply damage
                Global.getInstance().reportDamage(10);  // Report damage to Global
            }
        });
        return commands;
    }
}
