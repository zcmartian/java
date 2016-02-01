/**
 * Created by marszhou on 16/2/1.
 */
public abstract class Burger implements Item{

    @Override public Packing packing() {
        return new Wrapper();
    }

    @Override abstract public float price();
}
