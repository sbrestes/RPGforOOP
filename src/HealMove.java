import java.util.ArrayList;

public class HealMove extends Move{

    public String getTitle(){
        return "Heal";
    }

    @Override
    public ArrayList<Command> use(Character user, Character receiver) {
        ArrayList<Command> commands = new ArrayList<Command>();
        commands.add(new MessageCommand(user.getName() + " Heals " + user.getName() + "!"));
        commands.add(new AttackCommand(-3*user.getAttackPower(), user));
        commands.add(new CheckAndDisplayStatsCommand());
        return commands;
    }
}
