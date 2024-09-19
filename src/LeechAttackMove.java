import java.util.ArrayList;

public class LeechAttackMove extends Move{

    public String getTitle(){
        return "Leech Attack";
    }

    @Override
    public ArrayList<Command> use(Character user, Character receiver) {
        ArrayList<Command> commands = new ArrayList<Command>();
        commands.add(new MessageCommand(user.getName() + " uses a leech attack against " + receiver.getName() + "!"));
        commands.add(new LeechCommand(user.getAttackPower(), receiver, user));
        commands.add(new CheckAndDisplayStatsCommand());
        return commands;
    }
}
