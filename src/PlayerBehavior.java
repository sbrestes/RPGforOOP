import java.util.ArrayList;

public class PlayerBehavior extends Behavior{

    @Override
    public Move takeTurn(Scene scene, Character player) {
        scene.displayMessage("What will you do?");
        ArrayList<Move> options = player.getMoves();
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i+1) + ": " + options.get(i).getTitle());
        }
        int choice = scene.getIntInput(1, options.size() + 1) - 1;

        return options.get(choice);
    }
}
