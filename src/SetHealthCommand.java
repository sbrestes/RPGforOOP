public class SetHealthCommand extends Command{

    final private int ammount;
    final private Character defender;

    public SetHealthCommand(Character defender, int ammount) {
        this.defender = defender;
        this.ammount = ammount;
    }

    public void perform(Scene scene) {
        defender.setHp(ammount);
    }

}
