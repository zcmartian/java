/**
 * Created by marszhou on 16/9/8.
 */
public class ConcreteAggregate implements Aggregate {
    private String[] ss = null;

    public ConcreteAggregate(String[] ss) {
        this.ss = ss;
    }

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(this);
    }

    public Object get(int index) {
        Object retObj = null;
        if (index < ss.length) {
            retObj = ss[index];
        }
        return retObj;
    }

    public int size() {
        return ss.length;
    }
}
