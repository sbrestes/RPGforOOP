public class MoveDataPtrCommand extends Command {
    int delta = 0;

    public MoveDataPtrCommand(int offset) {
        delta = offset;
    }

    public void perform(Scene scene) {
        DataStorage.ptr = (DataStorage.ptr + delta + DataStorage.data.length) % DataStorage.data.length;
    }
}
