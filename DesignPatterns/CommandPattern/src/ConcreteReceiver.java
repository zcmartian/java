/**
 * Created by marszhou on 16/9/7.
 */
public class ConcreteReceiver implements Receiver {
    @Override
    public void action() {
        System.out.println("concreteReceiver action");
    }
}
