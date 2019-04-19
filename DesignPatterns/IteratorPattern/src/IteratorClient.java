/**
 * Created by marszhou on 16/9/8.
 */
public class IteratorClient {
    // 迭代器模式将一个集合的数据本身和对数据的访问解耦
    // 抽象一个迭代器定义了基本的访问集合的方法
    // 对于每个不同类型的集合定义一个专属的迭代器,此例中使用了工厂模式返回子迭代器对象
    // 迭代器应用在集合对象上,通过实现基本访问方法,对不同集合有不同的实现方式,
    // 例如,list 可以用 get 方法,而数组直接用下标
    // 在实际访问时,访问方法都是更新遍历的下标,然后通过具体集合各自的访问方法来对集合实现真正的访问
    // 但是在外界看来,迭代器有一个统一的接口,通过对统一的算法步骤的封装来实现可扩展性.
    public static void main(String[] args) {
        String[] names = {"张三", "李四", "王五"};
        Aggregate aggregate = new ConcreteAggregate(names);
        Iterator iterator = aggregate.createIterator();
        iterator.first();
        while (!iterator.isDone()) {
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
