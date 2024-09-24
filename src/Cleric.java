import java.util.ArrayList;

public class Cleric extends Character {

    public Cleric(Behavior behavior, String name, int maxHP) {
        super(behavior, name, maxHP);
    }

    public ArrayList<Move> getMoves() {
        ArrayList<Move> moves = new ArrayList<Move>();
        moves.add(new NormalAttackMove());
        moves.add(new HealMove());
        moves.add(new ShieldMove());
        moves.add(new LeechAttackMove());
        moves.add(new PoisonMove());
        moves.add(new SurrenderMove());
        return moves;
    }
}
