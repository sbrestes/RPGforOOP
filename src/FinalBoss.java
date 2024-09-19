import java.util.ArrayList;

public class FinalBoss extends Character {
    public Equipment weapon;
    public Equipment armor;
    private final String[] monologue;

    public FinalBoss(String name, int maxHP) {
        super(name, maxHP);
        this.weapon = new EldritchScythe();
        this.armor = new ChronoRing();
        this.maxMP = 1;
        this.mp = 0;
        monologue = new String[]{"So you thought you could stop me? How precious.",
                "You fought valiantly, I’ll give you that.",
                "But here we stand, and I am the one who emerges unscathed, the one with the final laugh.",
                "You believed in your cause, your righteousness, but in the end, it was all just a distraction—a beautiful delusion.",
                "Look at your fallen comrades.",
                "They fought for you, for an idea that has now crumbled before my might.",
                "You see, I didn’t just plan for this moment; I reveled in it.",
                "While you were busy dreaming of heroism and nobility, I was crafting a symphony of chaos.",
                "Every move you made played directly into my hands, every decision you took unwittingly pushed you closer to this very moment.",
                "You thought you could outsmart me with your strategies and your hope, but hope is a fragile thing, isn’t it? It breaks so easily under the weight of despair.",
                "You failed to recognize that despair was my ally all along.",
                "I sowed seeds of doubt in your hearts, whispered lies that gnawed at your resolve.",
                "Your faith in one another was your greatest weakness, and now, it is shattered.",
                "Do you feel it? The cold grip of defeat wrapping around your heart, squeezing the last vestiges of hope from your chest? This is what true power feels like.",
                "You stand there, battered and bruised, and all I feel is exhilaration.",
                "I’ve turned your strengths into vulnerabilities, and your greatest weapons into your own chains.",
                "You believed in justice, in balance, in a world where light vanquishes darkness.",
                "But I’ve shown you the truth: that the light can be blinding, and in its glare, you’ve become a fool.",
                "You placed your faith in a system that’s rigged, in a narrative that serves only to keep you in check while the real players move unseen in the shadows.",
                "And now, look around.",
                "This city, once vibrant and alive, is now a reflection of my power.",
                "I have reshaped it to my will, and in doing so, I have reshaped you.",
                "The fear that grips your heart? That’s mine.",
                "The uncertainty that fills your mind? I planted that seed, and it has grown beautifully.",
                "You wanted to be a hero, but what you’ve become is a reminder of how easily one can fall.",
                "This victory—my victory—is not just over you, but over the very ideals you held dear.",
                "I have dismantled your belief system, layer by layer, until all that’s left is the raw truth: that power, unchecked and unfettered, always triumphs.",
                "So take a moment to absorb this defeat, hero.",
                "Let it sink in, let it fester.",
                "You are not my adversary anymore; you are my cautionary tale.",
                "And as I reign over this world I’ve claimed, remember that your failure was my masterpiece.",
                "Your story ends here, while mine has only just begun."};
    }

    public int getAttackPower() {
        int amount = 2;
        if (weapon != null) {
            amount = weapon.adjustAttack(amount);
        }
        return amount;
    }

    public int dealDamage(int amount) {
        int newAmount = amount;
        if (armor != null) {
            newAmount = armor.adjustDefense(amount, maxHP);
        }
        hp -= newAmount;
        return newAmount;
    }

    public ArrayList<Move> getMoves() {
        ArrayList<Move> moves = new ArrayList<Move>();
        moves.add(new UltimateAttackMove(monologue));
        return moves;
    }
}