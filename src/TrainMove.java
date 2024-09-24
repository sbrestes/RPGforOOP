import java.util.ArrayList;

public class TrainMove extends Move{

    public String getTitle(){
        return "Strength Training";
    }

    @Override
    public ArrayList<Command> use(Character user, Character receiver) {
        ArrayList<Command> commands = new ArrayList<Command>();
        commands.add(new MessageCommand(user.getName() + " completes a workout and gains 2 attack power!"));
        commands.add(new TrainCommand(user));
        commands.add(new DisplayStrengthCommand());
        return commands;
    }
}