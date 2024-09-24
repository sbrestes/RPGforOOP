import java.util.ArrayList;

public class PlayerBehavior extends Behavior{

    @Override
    public Move takeTurn(Scene scene, Character player) {
        scene.displayMessage("What will you do?");
        ArrayList<Move> options = player.getLearnedMoves();
        String[] list = new String[options.size()];
        for (int i = 0; i < options.size(); i++) {
            list[i] = options.get(i).getTitle();
        }
        scene.displayOptions(list);
        int choice = scene.getIntInput(1, options.size() + 1) - 1;

        return options.get(choice);
    }

    @Override
    public ArrayList<Move> getStarterMoves(Character player) {
        ArrayList<Move> moves = player.getMoves();
        while (moves.size() > 2) {
            moves.remove(moves.size()-1);
        }
        return moves;
    }

}
