/**
 * Created by mars on 2017/1/22.
 */
public class Benford {
    public static void main(String[] args) {
        System.out.println("第一位数字");
        for (int i = 1; i < 10; i++) {
            System.out.println(String.format("是%d的概率: ", i) + String.format("%.10f", D1(i)));
        }

        for (int i = 1; i < 10; i++) {
            System.out.println(String.format("第%d位数字", i));
            for (int j = 0; j < 10; j++) {
                System.out.println(String.format("是%d的概率: ", j) + String.format("%.10f", DN(i, j)));
            }
        }
    }

    private static double D1(double d1) {
        return Math.log10(1 + 1 / d1);
    }

    private static double DN(int Nth, int d2) {
        double result = 0.0d;
        for (int i = (int) Math.pow(10d, Nth - 1); i < (int) Math.pow(10d, Nth); i++) {
            result += Math.log(1 + 1 / ((double) i * 10 + (double) d2));
        }
        return result / Math.log(10d);
    }
}
