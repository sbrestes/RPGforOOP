import java.util.ArrayList;

public class SurrenderMove extends Move{

    public String getTitle(){
        return "Surrender";
    }

    @Override
    public ArrayList<Command> use(Character user, Character receiver) {
        ArrayList<Command> commands = new ArrayList<Command>();
        commands.add(new MessageCommand(user.getName() + " surrenders " + "!"));
        commands.add(new SetHealthCommand(user, 0));
        commands.add(new CheckFightOverCommand());
        return commands;
    }
}
