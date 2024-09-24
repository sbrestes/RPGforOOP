import java.util.ArrayList;

public class Warrior extends Character {

    public Warrior(Behavior behavior, String name, int maxHP) {
        super(behavior, name, maxHP);
    }

    public Warrior(Behavior behavior, String name, int maxHP, Equipment weapon, Equipment armor) {
        super(behavior, name, maxHP);
    }

    public ArrayList<Move> getMoves() {
        ArrayList<Move> moves = new ArrayList<Move>();
        moves.add(new SurrenderMove());
        moves.add(new NormalAttackMove());
        moves.add(new MultiAttackMove(3));
        moves.add(new ShieldMove());
        moves.add(new HelloWorldMove());
        moves.add(new MagicDust(1));
        moves.add(new FreezeMove());
        return moves;
    }
}
