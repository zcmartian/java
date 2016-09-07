import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by marszhou on 16/9/7.
 */
public class MenuCommand implements ICommand {
    private Collection<ICommand> col = new ArrayList<ICommand>();

    public void addCommand(ICommand iCommand) {
        col.add(iCommand);
    }

    public Collection<ICommand> getCommands() {
        return col;
    }

    @Override
    public void execute() {
        // for (ICommand iCommand : col) {
        // iCommand.execute();
        // }
        CommandQueue.addMenu(this);
    }

    @Override
    public void setICook(ICook iCook) {

    }
}
