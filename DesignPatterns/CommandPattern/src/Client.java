/**
 * Created by marszhou on 16/9/7.
 */
public class Client {
    public Invoker assemble() {
        Receiver receiver = new ConcreteReceiver();
        Command command = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker();
        invoker.setCommand(command);
        return invoker;
    }

    public static void main(String[] args) {
        Client client = new Client();
        Invoker invoker = client.assemble();
        invoker.runCommand();
    }
}
