/**
 * Created by marszhou on 16/9/7.
 */
public class ConcreteCommand implements Command{

    private Receiver receiver;
    private String state;
    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        System.out.println("concreteCommand execute");
        receiver.action();
    }
}
