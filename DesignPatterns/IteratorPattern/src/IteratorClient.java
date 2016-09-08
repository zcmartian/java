import java.util.Collection;

/**
 * Created by marszhou on 16/9/8.
 */
public class IteratorClient {
    public static void main(String[] args) {
        String[] names = {"张三", "李四", "王五"};
        Aggregate aggregate = new ConcreteAggregate(names);
        Iterator iterator = aggregate.createIterator();
        iterator.first();
        while(!iterator.isDone()) {
            Object object = iterator.currentItem();
            System.out.println("the obj = " + object);
            iterator.next();
        }

        testIterator();
    }

    public static void testIterator() {
        PayManager payManager = new PayManager();
        payManager.calcPay();
        System.out.println("集团工资列表");
        test(payManager.createIterator());
        SalaryManager salaryManager = new SalaryManager();
        salaryManager.calcSalary();
        System.out.println("新收购工资列表");
        test(payManager.createIterator());
    }

    private static void test(Iterator iterator) {
        iterator.first();
        while (!iterator.isDone()) {
            Object obj = iterator.currentItem();
            System.out.println("the obj==" + obj);
            iterator.next();
        }
    }
}
