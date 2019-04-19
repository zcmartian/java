/**
 * Created by mars on 2017/1/24.
 */
public class TestOuter {
    public static void main(String args[]) {
        TestOuter outer = new TestOuter();
        TestOuter.InnerOne innerOne = outer.new InnerOne();
        TestOuter.InnerOne innerOne2 = new TestOuter().new InnerOne();
        innerOne.writeLine();
        innerOne2.writeLine();
        System.out.println(innerOne);
        System.out.println(innerOne2);
    }

    protected class InnerOne {
        public void writeLine() {
            System.out.println("Hello");
        }
    }
}
