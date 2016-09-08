/**
 * Created by marszhou on 16/9/8.
 */
public class PayModel {
    private String name;
    private double pay;

    @Override
    public String toString() {
        return "PayModel{" + "name='" + name + '\'' + ", pay=" + pay + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }
}
