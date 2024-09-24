import java.util.ArrayList;

public class EarlyClericBehavior extends Behavior {

    private boolean allMoves;

    public EarlyClericBehavior() {
        this.allMoves = false;
    }

    public EarlyClericBehavior(boolean allMoves) {
        this.allMoves = allMoves;
    }

    @Override
    public Move takeTurn(Scene scene, Character computer) {
        ArrayList<Move> opponentOptions = computer.getLearnedMoves();
        int opponentChoice = 0;
        return opponentOptions.get(opponentChoice);
    }

    @Override
    public ArrayList<Move> getStarterMoves(Character computer) {
        ArrayList<Move> moves = computer.getMoves();
        return moves;
    }
}

