import java.util.ArrayList;
import java.util.List;

/**
 * Created by marszhou on 16/9/7.
 */
public class CommandQueue {
    private static List<ICommand> cmds = new ArrayList<ICommand>();

    public synchronized static void addMenu(MenuCommand menuCommand) {
        for (ICommand cmd : menuCommand.getCommands()) {
            cmds.add(cmd);
        }
    }

    public synchronized static ICommand getFirstCommand() {
        ICommand cmd = null;
        if (cmds.size() >0) {
            cmd = cmds.get(0);
            cmds.remove(0);
        }
        return cmd;
    }
}
