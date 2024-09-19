import java.util.ArrayList;

public class MagicDust extends Move{

    public MagicDust (int num){
}
    public String getTitle(){
        return "Magic dust";
    }

    @Override
    public ArrayList<Command> use(Character user, Character receiver) {
        ArrayList<Command> commands = new ArrayList<Command>();
        int damage = -1;
        int num = (int) (Math.random() * 10);
        if (num>=0&&num<=5) {
            commands.add(new AttackCommand(3, receiver));
            commands.add(new MessageCommand("To little dust"));
        } else if (num>=6&&num<=7) {
            commands.add(new SetHealthCommand(user,0 ));
            commands.add(new MessageCommand("To much dust your dead"));
        }else if (num>=8&&num<=10) {
            commands.add(new AttackCommand(9, receiver));
            commands.add(new MessageCommand ("just right!!"));
        }

        commands.add(new CheckAndDisplayStatsCommand());
        return commands;
    }
}
