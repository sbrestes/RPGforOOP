public class PlayerCharacterFactory extends CharacterFactory {
    final public int defaultHp;
    final public int defaultMp;

    public PlayerCharacterFactory() {
        defaultHp = 10;
        defaultMp = 15;
    }

    public PlayerCharacterFactory(int defaultHp, int defaultMp) {
        this.defaultHp = defaultHp;
        this.defaultMp = defaultMp;
    }

    public Character build(Scene scene) {
        scene.displayMessage("What is your name?");
        String name = scene.getStringInput();
        scene.displayMessage("Which character would you like to play as?");
        scene.displayOptions(new String[] {"Warrior", "Mage", "Cleric", "Strength Trainer", "Wizzard", "Final Boss"});
        int choice = scene.getIntInput(1, 6);
        Character c;
        if (choice == 1) {
            c = new Warrior(new PlayerBehavior(), name + " the Warrior", defaultHp);
        } else if (choice == 2) {
            c = new Mage(new PlayerBehavior(), name + " the Mage", 2, 10);
        } else if (choice == 3){
            c = new Cleric(new PlayerBehavior(), name + " the Cleric", defaultHp);
        } else if (choice == 4){
            c = new StrengthTrainer(new PlayerBehavior(), name + " the Cleric", defaultHp);
        } else if (choice == 5){
            c = new Wizzard(new PlayerBehavior(), name + " the Wizzard", defaultHp);
        } else {
            c = new FinalBoss(new PlayerBehavior(), name + " the Final Boss", defaultHp);
        }

        return c;
    }
}
