import java.util.ArrayList;
import java.util.List;

/**
 * Created by marszhou on 16/9/8.
 */
public class PayManager implements Aggregate{
    private List list = new ArrayList();

    public List getList() {
        return list;
    }

    public void calcPay() {
        PayModel pm1 = new PayModel();
        pm1.setName("zhangsan");
        pm1.setPay(2800);
        PayModel pm2 = new PayModel();
        pm2.setName("lisi");
        pm2.setPay(5800);
        list.add(pm1);
        list.add(pm2);
    }

    public int size() {
        return list.size();
    }

    public Object get(int index) {
        Object object = null;
        if (index < list.size()) {
            return list.get(index);
        }
        return object;
    }

    @Override
    public Iterator createIterator() {
        return new CollectionIteratorImpl(this);
    }
}
