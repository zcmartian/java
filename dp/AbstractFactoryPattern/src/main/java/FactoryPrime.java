/**
 * Created by mars on 16/12/7.
 */
public class FactoryPrime extends AbstractFactory {
    @Override
    public ProductA produceA() {
        return new ProductAPrime();
    }

    @Override
    public ProductB produceB() {
        return new ProductBPrime();
    }
}
