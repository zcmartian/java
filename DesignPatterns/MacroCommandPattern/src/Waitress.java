/**
 * Created by marszhou on 16/9/7.
 */
public class Waitress {
    private MenuCommand menuCommand = new MenuCommand();

    public void orderDish(ICommand iCommand) {
//        ICook hotCook = new HotCook();
//        ICook coolCook = new CoolCook();
//
//        if (iCommand instanceof DuckCommand) {
//            ((DuckCommand) iCommand).setICook(hotCook);
//        } else if (iCommand instanceof ChopCommand) {
//            ((ChopCommand) iCommand).setICook(hotCook);
//        } else if (iCommand instanceof PorkCommand) {
//            ((PorkCommand) iCommand).setICook(coolCook);
//        }
        menuCommand.addCommand(iCommand);
    }

    public void orderComplete() {
        menuCommand.execute();
    }
}
