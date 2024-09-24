import java.util.ArrayList;

public class NormalAttackMove extends Move{

    public String getTitle(){
        return "Normal Attack";
    }

    @Override
    public ArrayList<Command> use(Character user, Character receiver) {
        ArrayList<Command> commands = new ArrayList<Command>();
        CritAttackCommand crit=new CritAttackCommand(user,receiver);
        commands.add(new MessageCommand(user.getName() + " uses a normal attack against " + receiver.getName() + "!"));
        commands.add(new AttackCommand(user.getAttackPower(), receiver));
      
        if(crit.ifCrit())
        {
            commands.add(crit);
            commands.add(new MessageCommand("CRIT!!!"));
        }
        
        commands.add(new CheckFightOverCommand());

        return commands;
    }
}
