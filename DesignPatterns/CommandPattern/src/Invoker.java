/**
 * Created by marszhou on 16/9/7.
 */
public class Invoker {
    private Command command = null;
    public void setCommand(Command command) {
        this.command = command;
    }
    public void runCommand() {
        command.execute();
    }
}
