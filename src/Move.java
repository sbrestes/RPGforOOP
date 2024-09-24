import java.util.ArrayList;

public abstract class Move implements Rewardable {

    public abstract String getTitle();

    public abstract ArrayList<Command> use(Character user, Character receiver);

    public void addToCharacter(Character c) {
        c.learnMove(this);
    }

    @Override
    public boolean equals(Object m) {
        if (m instanceof Move) {
            return getTitle().equals(((Move)m).getTitle());
        } else {
            return false;
        }
    }
}
