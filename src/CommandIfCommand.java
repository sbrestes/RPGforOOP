import java.util.ArrayList;
import java.util.concurrent.Callable;

public class CommandIfCommand extends Command {

    private Command cmd;
    private Callable<Boolean> callable;

    public CommandIfCommand(Command cmd, Callable<Boolean> callable) {
        this.cmd = cmd;
        this.callable = callable;
    }

    public void setCmd(Command cmd) {
        this.cmd = cmd;
    }

    public void perform(Scene scene) {
        try {
            if (callable.call()) {
                cmd.perform(scene);
            }
        } catch (Exception ignored) { }
    }
}
