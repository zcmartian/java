/**
 * Created by marszhou on 16/9/7.
 */
public class Client {
    public static void main(String[] args) {
//        Waitress waitress = new Waitress();
//        ICommand chop = new ChopCommand();
//        ICommand duck = new DuckCommand();
//        ICommand pork = new PorkCommand();
//
//        waitress.orderDish(chop);
//        waitress.orderDish(duck);
//        waitress.orderDish(pork);
//
//        waitress.orderComplete();
//
        CookManager.runCookManager();

        for (int i=0;i<5;++i) {
            Waitress waitress1 = new Waitress();
            ICommand chopCommand = new ChopCommand();
            ICommand duckCommand = new DuckCommand();
            waitress1.orderDish(chopCommand);
            waitress1.orderDish(duckCommand);
            waitress1.orderComplete();
        }
    }
}
