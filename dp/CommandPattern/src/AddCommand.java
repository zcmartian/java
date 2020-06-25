/**
 * Created by marszhou on 16/9/7.
 */
public class AddCommand implements CalculateCommand {
    private CalculateApi calculateApi = null;
    private int opeNum;

    public AddCommand(CalculateApi calculateApi, int opeNum) {
        this.calculateApi = calculateApi;
        this.opeNum = opeNum;
    }

    @Override
    public void execute() {
        calculateApi.add(opeNum);
    }

    @Override
    public void undo() {
        calculateApi.subtract(opeNum);
    }
}
