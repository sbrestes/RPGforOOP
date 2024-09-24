public class DisplayStatsCommand extends Command {

    @Override
    public void perform(Scene scene) {
        scene.displayMessage("Press Enter to Continue");
        scene.waitForEnter();
        scene.displayStats();
    }
}
