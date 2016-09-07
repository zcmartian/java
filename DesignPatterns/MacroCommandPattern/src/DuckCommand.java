/**
 * Created by marszhou on 16/9/7.
 */
public class DuckCommand implements ICommand {
    private ICook iCook;

    public void setICook(ICook iCook) {
        this.iCook = iCook;
    }

    @Override
    public void execute() {
        iCook.cook("烤鸭三吃");
    }
}
