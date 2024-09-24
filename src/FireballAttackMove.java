import java.util.ArrayList;

public class FireballAttackMove extends Move {

    final private int accuracy;

    public FireballAttackMove(int accuracy) {
        this.accuracy = accuracy;
    }

    public String getTitle() {
        return "Fireball";
    }

    @Override
    public ArrayList<Command> use(Character user, Character receiver) {
        int num = (int) (Math.random() * 100);
        ArrayList<Command> commands = new ArrayList<Command>();
        if (num > accuracy) {
            commands.add(new MessageCommand(user.getName() + " throws a fireball at " + receiver.getName() + "!"));
            commands.add(new MessageCommand("It's insanely effective"));
            commands.add(new AttackCommand(50, receiver));
            commands.add(new CheckFightOverCommand());
            return commands;
        } else {
            commands.add(new MessageCommand(user.getName() + " stubs their toe on a rock, missing their fireball!"));
            commands.add(new MessageCommand("You take 1 stubbed toe damage"));
            commands.add(new AttackCommand(1, user));
            commands.add(new CheckFightOverCommand());
            return commands;
        }

    }
}