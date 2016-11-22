/**
 * Created by mars on 16/11/22.
 */
public class Adapter implements IAdapte{
    private IExecutable iExecutable;

    public Adapter(IExecutable iExecutable) {
        this.iExecutable = iExecutable;
    }

    @Override
    public void execute() {
        iExecutable.executeOther();
        System.out.println("This is Adapter executing.");
    }
}
