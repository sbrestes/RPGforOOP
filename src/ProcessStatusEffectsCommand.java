public class ProcessStatusEffectsCommand extends Command {

    final private Character target;

    public ProcessStatusEffectsCommand(Character target) {
        this.target = target;
    }

    public void perform(Scene scene) {
        target.processStatusEffects(scene);
        for (int i = 0; i< target.statuses.size(); i++) {
            target.statuses.get(i).ExecuteEffect();

        }



        if (target.getMp() > 0) {
            scene.displayMessage("would you like to spend mp to poison you opponent?\n y/n");
            String poison_choice = scene.getStringInput();
            if (poison_choice.equals("y")) {
                target.statuses.add(new Poison(3, scene.getOpponent()));
            }
        }
    }

}

