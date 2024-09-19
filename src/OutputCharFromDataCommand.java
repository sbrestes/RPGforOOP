public class OutputCharFromDataCommand extends Command {
    public void perform(Scene scene) {
        System.out.print((char) DataStorage.data[DataStorage.ptr]);
    }
}
