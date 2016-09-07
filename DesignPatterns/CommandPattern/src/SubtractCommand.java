/**
 * Created by marszhou on 16/9/7.
 */
public class SubtractCommand implements CalculateCommand{
    private CalculateApi calculateApi = null;
    private int opeNum;

    public SubtractCommand(CalculateApi calculateApi, int opeNum) {
        this.calculateApi = calculateApi;
        this.opeNum = opeNum;
    }

    @Override
    public void execute() {
        calculateApi.subtract(opeNum);
    }

    @Override
    public void undo() {
        calculateApi.add(opeNum);
    }
}
