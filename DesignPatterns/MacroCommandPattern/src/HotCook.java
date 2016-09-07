/**
 * Created by marszhou on 16/9/7.
 */
public class HotCook implements ICook, Runnable {
    private String name;
    public HotCook(String name) {
        this.name = name;
    }
    @Override
    public void cook(String name) {
        int cookTime = (int) (20*Math.random());
        System.out.println("本厨师正在做: " + name);
        try{
            Thread.sleep(cookTime);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("菜做好了,共耗时" + cookTime + "秒");
    }

    public void run() {
        while(true) {
            ICommand cmd = CommandQueue.getFirstCommand();
            if (cmd != null) {
                cmd.setICook(this);
                cmd.execute();
            }
            try{
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
