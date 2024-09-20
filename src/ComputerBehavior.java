import java.util.ArrayList;

public class ComputerBehavior extends Behavior {

    private boolean allMoves;

    public ComputerBehavior() {
        this.allMoves = false;
    }

    public ComputerBehavior(boolean allMoves) {
        this.allMoves = allMoves;
    }

    @Override
    public Move takeTurn(Scene scene, Character computer) {
        ArrayList<Move> opponentOptions = computer.getLearnedMoves();
        int opponentChoice = (int)(Math.random() * opponentOptions.size());
        return opponentOptions.get(opponentChoice);
    }

    @Override
    public ArrayList<Move> getStarterMoves(Character computer) {
        ArrayList<Move> moves = computer.getMoves();
        while (!allMoves && moves.size() > Global.getInstance().getLevel() / 5 + 1) {
            moves.remove(moves.size()-1);
        }
        return moves;
    }
}
