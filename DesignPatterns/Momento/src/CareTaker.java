import java.util.ArrayList;
import java.util.List;

/**
 * Created by marszhou on 16/2/21.
 */
public class CareTaker {
    private List<Memento> momentoList = new ArrayList<Memento>();

    public void add(Memento memento) {
        momentoList.add(memento);
    }

    public Memento get(int index) {
        return momentoList.get(index);
    }
}
