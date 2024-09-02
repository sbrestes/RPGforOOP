import java.util.ArrayList;

public abstract class Move {

    public abstract String getTitle();

    public abstract ArrayList<Command> use(Character user, Character receiver);
}
