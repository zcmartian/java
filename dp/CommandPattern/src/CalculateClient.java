/**
 * Created by marszhou on 16/9/7.
 */
public class CalculateClient {
    public static void main(String[] args) {
        CalculateApi calculateApi = new ConcreteCalculateApi();

        AddCommand addCommand = new AddCommand(calculateApi, 5);
        SubtractCommand subtractCommand = new SubtractCommand(calculateApi, 3);

        Calculator calculator = new Calculator();
        calculator.setAddCmd(addCommand);
        calculator.setSubCmd(subtractCommand);

        calculator.addPressed();
        System.out.println("一次加法运算后的结果为:" + calculateApi.getResult());

        calculator.subPressed();
        System.out.println("一次减法运算后的结果为:" + calculateApi.getResult());

        calculator.undoPressed();
        System.out.println("一次撤销操作后的结果为:" + calculateApi.getResult());

        calculator.undoPressed();
        System.out.println("再一次撤销操作后的结果为:" + calculateApi.getResult());

        calculator.redoPressed();
        System.out.println("恢复一次操作后的结果为:" + calculateApi.getResult());

        calculator.redoPressed();
        System.out.println("再恢复一次操作后的结果为:" + calculateApi.getResult());
    }
}
