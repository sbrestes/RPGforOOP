import java.util.ArrayList;

public class Mage extends Character {

    public Mage(Behavior behavior, String name, int maxHP, int maxMp) {
        super(behavior, name, maxHP, maxMp);
    }

    public void levelUp(Scene scene) {
        int hpUp = (int)(Math.random() * 3) + 1;
        int mpUp = (int)(Math.random() * 3) + 1;
        scene.displayMessage("Level up! Max HP went up by " + hpUp + " and max MP went up by " + mpUp);
        setMaxHP(getMaxHP() + hpUp);
        setHp(getHp() + hpUp);
        setMaxMP(getMaxMP() + hpUp);
        setMp(getMp() + mpUp);
    }

    public ArrayList<Move> getMoves() {
        ArrayList<Move> moves = new ArrayList<Move>();
        moves.add(new NormalAttackMove());
        moves.add(new FireballAttackMove(50));
        moves.add(new MagicDust(1));
        moves.add(new FreezeMove());
        moves.add(new SurrenderMove());
        moves.add(new HealMove());
        moves.add(new PoisonMove());
        moves.add(new LightningStrikeMove());
        moves.add(new LeechAttackMove());
        return moves;
    }
}
