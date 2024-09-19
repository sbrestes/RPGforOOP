public class ProcessStatusEffectsCommand extends Command {

    final private Character target;

    public ProcessStatusEffectsCommand(Character target) {
        this.target = target;
    }

    public void perform(Scene scene) {
        target.processStatusEffects();
    }

}

