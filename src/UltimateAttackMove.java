import java.util.ArrayList;

public class UltimateAttackMove extends Move {
    public String getTitle() {
        return "Ultimate Attack";
    }

    final private String[] monologue;

    public UltimateAttackMove(String[] monologue) {
        this.monologue = monologue;
    }

    @Override
    public ArrayList<Command> use(Character user, Character receiver) {
        ArrayList<Command> commands = new ArrayList<Command>();
        if(user.getMp() < 1) {
            commands.add(new MessageCommand(user.getName() + " is charging up"));
            commands.add(new DeferMoveCommand(new UltimateAttackMove(monologue), user, receiver));
            user.setMp(user.getMp() + 1);
        } else {
            for (String line : monologue) {
                commands.add(new MessageCommand(line));
                commands.add(new MessageCommand("press enter..."));
                commands.add(new InputCommand());
            }
            commands.add(new MessageCommand("bye bye"));
            commands.add(new MessageCommand(user.getName() + " uses an ultimate attack against " + receiver.getName() + "!"));
            commands.add(new AttackCommand(user.getAttackPower(), receiver));
            commands.add(new CheckFightOverCommand());
        }
        return commands;
    }
}