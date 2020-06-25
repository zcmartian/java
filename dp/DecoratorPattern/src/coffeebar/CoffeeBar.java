package coffeebar;

import coffeebar.coffee.Decaf;
import coffeebar.coffee.LongBlack;
import coffeebar.decorator.Chocolate;
import coffeebar.decorator.Milk;
import coffeebar.decorator.Soy;

public class CoffeeBar {

    public static void main(String[] args) {

        Drink order;
        order = new Decaf();
        System.out.println("order1 price:" + order.cost());
        System.out.println("order1 desc:" + order.getDescription());

        System.out.println("****************");
        order = new LongBlack();
        order = new Milk(order);
        order = new Soy(order);
        order = new Chocolate(order);
        System.out.println("order2 price:" + order.cost());
        System.out.println("order2 desc:" + order.getDescription());

    }

}
