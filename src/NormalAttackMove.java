import java.util.ArrayList;

public class NormalAttackMove extends Move{

    public String getTitle(){
        return "Normal Attack";
    }

    public ArrayList<Command> use(Character user, Character receiver) {
        ArrayList<Command> commands = new ArrayList<Command>();
        commands.add(new MessageCommand(user.getName() + " uses a normal attack against " + receiver.getName() + "!"));
        commands.add(new AttackCommand(user.getAttackPower(), receiver));
        commands.add(new CheckAndDisplayStatsCommand());
        return commands;
    }
}
