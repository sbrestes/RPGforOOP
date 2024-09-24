import java.util.ArrayList;

public class EarlyMageBehavior extends Behavior {

    private boolean allMoves;

    public EarlyMageBehavior() {
        this.allMoves = false;
    }

    public EarlyMageBehavior(boolean allMoves) {
        this.allMoves = allMoves;
    }

    @Override
    public Move takeTurn(Scene scene, Character computer) {
        ArrayList<Move> opponentOptions = computer.getLearnedMoves();
        int opponentChoice = 1;
        return opponentOptions.get(opponentChoice);
    }

    @Override
    public ArrayList<Move> getStarterMoves(Character computer) {
        ArrayList<Move> moves = computer.getMoves();
        return moves;
    }
}

