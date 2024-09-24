public class OpponentCharacterFactory extends CharacterFactory {

    public int defaultHP = 100;

    @Override
    public Character build(Scene scene) {

        int level = Global.getInstance().getLevel();

        Weapon w = null;
        Equipment e = null;
        int randW = (int)(Math.random() * level);
        int randE = (int)(Math.random() * level);
        if (randW > 50) {
            w = new EldritchScythe();
        } else if (randW > 15) {
            w = new Mace();
        } else if (randW > 10) {
            w = new Sword();
        } else if (randW > 5) {
            w = new Staff();
        }

        if (randE > 50) {
            e = new ChronoRing();
        } else if (randE > 15) {
            e = new BronzePlate();
        } else if (randE > 10) {
            e = new LeatherArmor();
        } else if (randE > 5) {
            e = new Shirt();
        }

        String[] names = {
                "Sten",
                "Grady",
                "Yuyang",
                "Estes",
                "Samir",
                "Sean",
                "Luke",
                "Alex",
                "Julia",
                "Jackson",
                "Lav",
                "Jonas",
                "Chris"
        };
        String name = names[(int)(Math.random() * names.length)];
        Character o;

        switch ((int)(Math.random() * 5)){
            case 0:
                o = new FinalBoss(new ComputerBehavior(true), name + " the Final Boss", (int)(Math.random() * 50));
                if (level > 25){
                    if (Math.random() > 0.5) {
                        o.setWeapon(new EldritchScythe());
                        o.setEquipment(new ChronoRing());
                    }
                    break;
                }
            case 1:
                o = new Warrior(new ComputerBehavior(), name + " the Warrior", (int)(Math.random() * 10) + level);
                break;
            case 2:
                if (level < 7) {
                    o = new Mage(new EarlyMageBehavior(level > 15), name + " the Mage", (int) (Math.random() * level + 1), 50);
                    break;
                }else {
                    o = new Mage(new ComputerBehavior(level > 15), name + " the Mage", (int) (Math.random() * level + 1), 50);
                    break;
                }
            case 3:
                if (level < 10) {
                    o = new Cleric(new ComputerBehavior(level > 10), name + " the Cleric", (int) (Math.random() * 15) + level);
                    break;
                } else {
                    o = new Cleric(new ComputerBehavior(level > 10), name + " the Cleric", (int) (Math.random() * 15) + level);
                    break;
                }
            default:
                o = new StrengthTrainer(new ComputerBehavior(level > 15), name + " the Strength Trainer", (int)(Math.random() * 5) + level);
                break;
        }

        o.setWeapon(w);
        o.setEquipment(e);

        return o;
    }
}
