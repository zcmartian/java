/**
 * Created by marszhou on 16/9/8.
 */
public class SalaryManager implements Aggregate{
    private PayModel[] pms = new PayModel[10];

    public PayModel[] getPays() {
        return pms;
    }

    public void calcSalary() {
        PayModel pm1 = new PayModel();
        pm1.setName("wangwu");
        pm1.setPay(1800);
        PayModel pm2 = new PayModel();
        pm2.setName("zhaoliu");
        pm2.setPay(8800);
        pms[0] = pm1;
        pms[1] = pm2;
    }

    public int size() {
        return pms.length;
    }

    public Object get(int index) {
        Object object = null;
        if (index < pms.length) {
            return pms[index];
        }
        return object;
    }

    @Override
    public Iterator createIterator() {
        return new ArrayIteratorImpl(this);
    }
}
