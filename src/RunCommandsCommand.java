public class RunCommandsCommand extends Command {
    private final Command[] commands;
    
    public RunCommandsCommand(Command... cmds) {
        commands = cmds;
    }

    public void perform(Scene scene) {
        for (Command cmd : commands) {
            cmd.perform(scene);
        }
    }
}
