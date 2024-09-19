import java.util.ArrayList;
public class PoisonMove extends Move {
    @Override
    public String getTitle() {
        return "Poison";
    }

    @Override
    public ArrayList<Command> use(Character user, Character receiver) {
        ArrayList<Command> commands = new ArrayList<>();
        commands.add(new Command() {
            @Override
            public void perform(Scene scene) {
                scene.displayMessage(user.getName() + " poisons " + receiver.getName() + "!");
                receiver.applyStatusEffect(new PoisonEffect(3)); // Assuming a PoisonEffect class for 3 turns
            }
        });
        return commands;
    }
}