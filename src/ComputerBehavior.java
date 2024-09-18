import java.util.ArrayList;

public class ComputerBehavior extends Behavior {

    @Override
    public Move takeTurn(Scene scene, Character computer) {
        ArrayList<Move> opponentOptions = computer.getMoves();
        int opponentChoice = (int)(Math.random() * opponentOptions.size());
        return opponentOptions.get(opponentChoice);
    }
}
