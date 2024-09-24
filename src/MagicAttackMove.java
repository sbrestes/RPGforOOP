import java.util.ArrayList;
import java.util.Scanner;

public class MagicAttackMove extends Move {



    public MagicAttackMove() {
    }

    public String getTitle() {
        return "Magic";
    }
    Scanner scan = new Scanner(System.in);
    @Override
    public ArrayList<Command> use(Character user, Character receiver) {
        int num = (int) (Math.random() * 100);
        int  nums = (int) (Math.random() * 2);

        ArrayList<Command> commands = new ArrayList<Command>();
        if (nums == 0) {
            commands.add(new MessageCommand(user.getName() + " Uses Episkey spell which heals 2 health"));
            commands.add(new AttackCommand(-2, user));
        }
        else if (nums == 1) {
            if (num > 80) {
                commands.add(new MessageCommand(user.getName() + "Uses spell Avada Kedavra and " + receiver.getName() + " is dead"));
                commands.add(new AttackCommand(2147483647, receiver));
            } else {
                commands.add(new MessageCommand(user.getName() + "Tries to use spell Avada Kedavra on " + receiver.getName() + " and the spell backfired and " + user.getName() + "take 2 damage"));
                commands.add(new AttackCommand(2, user));
            }

        }


        commands.add(new CheckFightOverCommand());
        return commands;

    }
}