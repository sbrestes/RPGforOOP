public class AddToDataAtPtrCommand extends Command {
    int amount = 0;

    public AddToDataAtPtrCommand(int amt) {
        amount = amt;
    }

    public void perform(Scene scene) {
        DataStorage.data[DataStorage.ptr] += amount + 256;
        DataStorage.data[DataStorage.ptr] %= 256;
    }
}
