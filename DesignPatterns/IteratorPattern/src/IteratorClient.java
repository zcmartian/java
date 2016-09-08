/**
 * Created by marszhou on 16/9/8.
 */
public class IteratorClient {
    public static void main(String[] args) {
        String[] names = {"张三", "李四", "王五"};
        Aggregate aggregate = new ConcreteAggregate(names);
        Iterator iterator = aggregate.createItertor();
        iterator.first();
        while(!iterator.isDone()) {
            Object object = iterator.currentItem();
            System.out.println("the obj = " + object);
            iterator.next();
        }
    }
}
