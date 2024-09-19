import java.util.ArrayList;

public class ShieldMove extends Move {
    @Override
    public String getTitle() {
        return "Shield";
    }

    @Override
    public ArrayList<Command> use(Character user, Character receiver) {
        ArrayList<Command> commands = new ArrayList<>();
        commands.add(new Command() {
            @Override
            public void perform(Scene scene) {
                scene.displayMessage(user.getName() + " raises a shield! Reduced damage for 3 turns.");
                user.applyStatusEffect(new ShieldEffect(3)); // Assuming a ShieldEffect class for 3 turns
            }
        });
        return commands;
    }
}