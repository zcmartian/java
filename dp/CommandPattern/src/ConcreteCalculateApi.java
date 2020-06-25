/**
 * Created by marszhou on 16/9/7.
 */
public class ConcreteCalculateApi implements CalculateApi {
    private int result;

    @Override
    public int getResult() {
        return result;
    }

    @Override
    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public void add(int num) {
        result += num;
    }

    @Override
    public void subtract(int num) {
        result -= num;
    }
}
