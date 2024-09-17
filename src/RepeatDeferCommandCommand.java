import java.util.ArrayList;

public class RepeatDeferCommandCommand extends Command {

    long times;
    Command callbackCmd;

    public RepeatDeferCommandCommand(long times, Command cmd) {
        this.times = times;
        this.callbackCmd = cmd;
    }

    public void perform(Scene scene) {
        ArrayList<Command> cmds = new ArrayList<>();
        if (times == 0) {
            return;
        }
        callbackCmd.perform(scene);
        RepeatDeferCommandCommand doTimesCommand = new RepeatDeferCommandCommand(times-1, callbackCmd);
        cmds.add(doTimesCommand);
        scene.addCommands(cmds);
    }
}
