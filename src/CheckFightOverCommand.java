public class CheckFightOverCommand extends Command{

    @Override
    public void perform(Scene scene) {
        scene.checkForFightOver();
    }
}
