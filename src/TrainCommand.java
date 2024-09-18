public class TrainCommand extends Command{
    final private Character trainer;

    public TrainCommand(Character trainer) {
        this.trainer = trainer;
    }
    public void perform(Scene scene){
        trainer.setMp(trainer.mp + 10);
    }
}