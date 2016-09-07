import java.util.ArrayList;
import java.util.List;

/**
 * Created by marszhou on 16/9/7.
 */
public class Calculator {
    private CalculateCommand addCmd = null;
    private CalculateCommand subCmd = null;
    private List<CalculateCommand> undoCmds = new ArrayList<CalculateCommand>();
    private List<CalculateCommand> redoCmds = new ArrayList<CalculateCommand>();

    public void setAddCmd(CalculateCommand addCmd) {
        this.addCmd = addCmd;
    }

    public void setSubCmd(CalculateCommand subCmd) {
        this.subCmd = subCmd;
    }

    public void addPressed() {
        addCmd.execute();
        undoCmds.add(addCmd);
    }

    public void subPressed() {
        subCmd.execute();
        undoCmds.add(subCmd);
    }

    public void undoPressed() {
        if (undoCmds.size() > 0) {
            CalculateCommand cmd = undoCmds.get(undoCmds.size() - 1);
            cmd.undo();
            redoCmds.add(cmd);
            undoCmds.remove(cmd);
        } else {
            System.out.println("没有可以撤销的命令");
        }
    }

    public void redoPressed() {
        if (redoCmds.size() > 0) {
            CalculateCommand cmd = redoCmds.get(redoCmds.size() - 1);
            cmd.execute();
            undoCmds.add(cmd);
            redoCmds.remove(cmd);
        } else {
            System.out.println("没有可以恢复的命令");
        }
    }
}
