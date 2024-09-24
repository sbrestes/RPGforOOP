public class Poison extends Status {
    public Poison(int duration, Character target){
        super(duration, target);

    }
    @Override
    public void ExecuteEffect() {

        if (target.hp > 0){
            target.setHp(target.hp-1);
            System.out.println("poison dealt 1 damage to ".concat(target.name));
        }

    }
}