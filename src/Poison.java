public class Poison extends Status {
    public Poison(int duration, Character target){
        super(duration, target);

    }
    @Override
    public void ExecuteEffect() {

        if (target.getHp() > 0){
            target.setHp(target.getHp()-1);
            System.out.println("poison dealt 1 damage to ".concat(target.getName()));
        }

    }
}