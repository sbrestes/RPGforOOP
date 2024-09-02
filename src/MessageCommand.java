public class MessageCommand extends Command{

    final private String message;

    public MessageCommand(String message) {
        this.message = message;
    }

    @Override
    public void perform(Scene scene) {
        scene.displayMessage(message);
    }
}
