import java.util.ArrayList;

public abstract class Behavior {
    public abstract Move takeTurn(Scene scene, Character character);
    public abstract ArrayList<Move> getStarterMoves(Character player);
}
