package coffeebar.decorator;

import coffeebar.Drink;

public class Decorator extends Drink {
    private Drink Obj;

    public Decorator(Drink Obj) {
        this.Obj = Obj;
    };

    @Override
    public float cost() {
        // TODO Auto-generated method stub
        float price = super.getPrice();
        float objPrice = Obj.cost();
        return price + objPrice;
    }

    @Override
    public String getDescription() {
        return super.description + "-" + super.getPrice() + "&&" + Obj.getDescription();
    }

}
