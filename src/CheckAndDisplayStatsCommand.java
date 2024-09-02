public class CheckAndDisplayStatsCommand extends Command{

    @Override
    public void perform(Scene scene) {
        scene.displayStats();
        scene.checkForGameOver();
    }
}
