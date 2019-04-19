/**
 * Created by mars on 16/12/7.
 */
public class FactoryMedium extends AbstractFactory {
    @Override
    public ProductA produceA() {
        return new ProductAMedium();
    }

    @Override
    public ProductB produceB() {
        return new ProductBMedium();
    }
}
