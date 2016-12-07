/**
 * Created by mars on 16/12/7.
 */
public class Client {
    public static void main(String[] args){
        AbstractFactory factoryPrime = new FactoryPrime();
        AbstractFactory factoryMedium = new FactoryMedium();

        ProductA primeA = factoryPrime.produceA();
        ProductB primeB = factoryPrime.produceB();

        ProductA mediumA = factoryMedium.produceA();
        ProductB mediumB = factoryMedium.produceB();

        primeA.operation1();
        primeA.operation2();

        primeB.operation1();
        primeB.operation2();

        mediumA.operation1();
        mediumA.operation2();

        mediumB.operation1();
        mediumB.operation2();

        //A,B是产品, Prime和Medium是产品簇
        //产品不能扩展,产品簇可以扩展
        //扩展产品簇的时候只要新加一个具体工厂,然后实现里面的工厂方法,增加对应A,B产品就行了,做到了对扩展开放
        //扩展产品,需要将所有具体工厂类都增加响应的工厂方法,没有对修改封闭
    }
}
