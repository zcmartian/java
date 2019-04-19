import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

interface Data {
    String getResult();
}

public class Main3 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Client client = new Client();
        Data data = client.request("name");
        System.out.println("请求完毕");
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//
//        }
        System.out.println("数据=" + data.getResult());

        FutureTask<String> future = new FutureTask<String>(new RealData2("a"));
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(future);
        System.out.println("请求完毕");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        System.out.println("数据=" + data.getResult());
        executorService.shutdown();
    }
}

class RealData2 implements Callable<String> {
    private String para;

    public RealData2(String para) {
        this.para = para;
    }

    @Override
    public String call() throws Exception {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; ++i) {
            sb.append(para);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        return sb.toString();
    }
}