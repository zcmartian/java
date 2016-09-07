/**
 * Created by marszhou on 16/9/7.
 */
public class PorkCommand implements ICommand{
    private ICook iCook;
    public void setICook(ICook iCook) {
        this.iCook = iCook;
    }
    @Override
    public void execute() {
        iCook.cook("酱排骨");
    }
}
