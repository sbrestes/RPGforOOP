import java.util.ArrayList;

public class HelloWorldMove extends Move {
    public String getTitle() {
        return "Hello World";
    }

    public ArrayList<Command> use(Character user, Character receiver) {
        receiver.dealDamage(1);
        DataStorage.data = new int[100];
        ArrayList<Command> cmds = new ArrayList<>();
        cmds.add(new RunCommandsCommand(
                new AddToDataAtPtrCommand(1),
                new RepeatWhileDataAtPtrCommand(new RunCommandsCommand(
                        new AddToDataAtPtrCommand(-2),
                        new MoveDataPtrCommand(1),
                        new AddToDataAtPtrCommand(-1),
                        new RepeatWhileDataAtPtrCommand(new RunCommandsCommand(
                                new MoveDataPtrCommand(2),
                                new AddToDataAtPtrCommand(1),
                                new MoveDataPtrCommand(1),
                                new AddToDataAtPtrCommand(-5),
                                new MoveDataPtrCommand(-2)
                        )),
                        new MoveDataPtrCommand(-1),
                        new AddToDataAtPtrCommand(-2),
                        new MoveDataPtrCommand(-1),
                        new AddToDataAtPtrCommand(-3)
                )),
                new MoveDataPtrCommand(1),
                new AddToDataAtPtrCommand(-1),
                new OutputCharFromDataCommand(),
                new MoveDataPtrCommand(3),
                new AddToDataAtPtrCommand(1),
                new OutputCharFromDataCommand(),
                new MoveDataPtrCommand(2),
                new OutputCharFromDataCommand(),
                new OutputCharFromDataCommand(),
                new AddToDataAtPtrCommand(3),
                new RepeatWhileDataAtPtrCommand(new RunCommandsCommand(
                        new OutputCharFromDataCommand(),
                        new MoveDataPtrCommand(1)
                )),
                new MoveDataPtrCommand(-4),
                new OutputCharFromDataCommand(),
                new AddToDataAtPtrCommand(3),
                new OutputCharFromDataCommand(),
                new AddToDataAtPtrCommand(-6),
                new OutputCharFromDataCommand(),
                new MoveDataPtrCommand(-2),
                new AddToDataAtPtrCommand(-1),
                new OutputCharFromDataCommand(),
                new MoveDataPtrCommand(4),
                new AddToDataAtPtrCommand(1),
                new OutputCharFromDataCommand()
        ));
        return cmds;
    }
}
