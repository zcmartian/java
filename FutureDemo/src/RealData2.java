import java.util.concurrent.Callable;

/**
 * Created by marszhou on 16/1/7.
 */
public class RealData2 implements Callable<String> {
    private String para;
    public RealData2(String para) {
        this.para = para;
    }

    @Override
    public String call() throws Exception {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<10;++i) {
            sb.append(para);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
        }
        return sb.toString();
    }
}
