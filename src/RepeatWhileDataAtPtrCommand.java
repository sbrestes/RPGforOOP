public class RepeatWhileDataAtPtrCommand extends Command {
    Command cmd;

    public RepeatWhileDataAtPtrCommand(Command cmd) {
        this.cmd = cmd;
    }

    public void perform(Scene scene) {
        CommandIfCommand ifcmd = new CommandIfCommand(null, () -> DataStorage.data[DataStorage.ptr] != 0);
        ifcmd.setCmd(new RunCommandsCommand(this.cmd, ifcmd));
        ifcmd.perform(scene);
    }
}
