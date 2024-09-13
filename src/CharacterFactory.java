public class CharacterFactory {

    final public int defaultHp;
    final public int defaultMp;

    public CharacterFactory() {
        defaultHp = 30;
        defaultMp = 15;
    }

    public CharacterFactory(int defaultHp, int defaultMp) {
        this.defaultHp = defaultHp;
        this.defaultMp = defaultMp;
    }

    public Character build(Scene scene, String name) {
        scene.displayMessage("1. Warrior");
        scene.displayMessage("2. Mage");
        int choice = scene.getIntInput(1, 3);
        Character c;
        if (choice == 1) {
            c = new Warrior(name, defaultHp, new Sword(), new BronzePlate());
        } else {
            c = new Mage(name, 2, new Staff(), new LeatherArmor());
        }
        return c;
    }
}
