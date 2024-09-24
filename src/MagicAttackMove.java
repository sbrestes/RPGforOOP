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
        int  nums = (int) (Math.random() * 5);

        ArrayList<Command> commands = new ArrayList<Command>();
        commands.add(new MessageCommand(user.getName() + "Pick an Attack /n 1. Heal /n 2. Disable Enemy /n 3. Temp Shield /n 4. "));
        if (nums == 1) {
            commands.add(new MessageCommand(user.getName() + " Uses Episkey spell which heals 2 health"));
            commands.add(new AttackCommand(-2, user));
        } else if (nums == 2){
            commands.add(new MessageCommand(user.getName() + "Uses Expelliarmus spell the" +receiver.getName() + "loses his wand and can't attack for one turn"));
            commands.add(new Command() {
                @Override
                public void perform(Scene scene) {
                    receiver.setFrozen(true);
                }
            });
        }
        else if (nums == 3){
            commands.add(new MessageCommand(user.getName() + "Uses Expecto Patronum spell and he doesn't take damgage for the next round"));

        }
        else if (nums == 4){
            if(num > 80){
                commands.add(new MessageCommand(user.getName() + "get a weapon the has 2x damage"));
                commands.add(new Command() {
                    @Override
                    public void perform(Scene scene) {
                       user.setMultiply(true);
                    }
                });
            }
            else{

                commands.add(new MessageCommand(receiver.getName() + "get a weapon the has 2x damage"));
                commands.add(new Command() {
                    @Override
                    public void perform(Scene scene) {
                        receiver.setMultiply(true);
                    }
                });
            }

        }
        else if (nums == 5){
            if(num > 80){
                commands.add(new MessageCommand(user.getName() + "Uses spell Avagitda Kedavra and "+receiver.getName()+"is dead"));
                commands.add(new AttackCommand(2147483647, receiver));
            }
            else{
                commands.add(new MessageCommand(user.getName() + "Tries to use spell Avada Kedavra on "+receiver.getName()+" and the spell backfired and "+user.getName()+"take 2 damage"));
                commands.add(new AttackCommand(2, user));
            }

        }


        commands.add(new CheckAndDisplayStatsCommand());
        return commands;

    }
}