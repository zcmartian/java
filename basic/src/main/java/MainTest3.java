public class MainTest3 {

    private int stackLength = 1;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MainTest3 test = new MainTest3();
        try {
            test.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + test.stackLength);
            throw e;
        }
    }

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

}
