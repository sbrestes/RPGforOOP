import java.util.ArrayList;
import java.util.concurrent.Callable;

public class DeferCommandIfCommand extends Command {

    private Command cmd;
    private Callable<Boolean> callable;

    public DeferCommandIfCommand(Command cmd, Callable<Boolean> callable) {
        this.cmd = cmd;
        this.callable = callable;
    }

    public void perform(Scene scene) {
        try {
            if (callable.call()) {
                ArrayList<Command> cmds = new ArrayList<>();
                cmds.add(cmd);
                scene.addCommands(cmds);
            }
        } catch (Exception ignored) { }
    }
}
