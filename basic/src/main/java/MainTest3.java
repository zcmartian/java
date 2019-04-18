public class MainTest {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MainTest test = new MainTest();
        try {
            test.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + test.stackLength);
            throw e;
        }
    }

}
