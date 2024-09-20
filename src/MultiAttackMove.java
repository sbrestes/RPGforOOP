import java.util.ArrayList;

public class MultiAttackMove extends Move{

    final private int maxHits;

    public MultiAttackMove(int maxHits) {
        this.maxHits = maxHits;
    }

    public String getTitle(){
        return "Multi Attack x" + maxHits;
    }

    @Override
    public ArrayList<Command> use(Character user, Character receiver) {
        int num = (int)(Math.random() * maxHits + 1);
        ArrayList<Command> commands = new ArrayList<Command>();
        commands.add(new MessageCommand(user.getName() + " uses a multi attack against " + receiver.getName() + "!"));
        commands.add(new MessageCommand("Hits " + num + " time(s)!"));
        for (int i = 0; i < num; i++) {
            commands.add(new AttackCommand(user.getAttackPower(), receiver));
        }
        commands.add(new CheckFightOverCommand());
        commands.add(new MessageCommand(user.getName() + " takes 2 damage as recoil!"));
        commands.add(new AttackCommand(2, user));
        commands.add(new CheckFightOverCommand());
        return commands;
    }
}
