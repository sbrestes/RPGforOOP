import java.util.ArrayList;

public class DeferMoveCommand extends Command{

    private final Move move;
    private final Character user;
    private final Character receiver;

    public DeferMoveCommand(Move move, Character user, Character receiver) {
        this.move = move;
        this.user = user;
        this.receiver = receiver;
    }

    public void perform(Scene scene) {
        ArrayList<Command> commands = move.use(user, receiver);
        scene.addCommands(commands);
    }
}
