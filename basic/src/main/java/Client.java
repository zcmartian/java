
/**
 * Created by marszhou on 16/1/7.
 */
public class Client {
    public Data request(final String queryStr) {
        final MyFuture future = new MyFuture();

        new Thread() {
            public void run() {
                RealData realData = new RealData(queryStr);
                future.setRealData(realData);
            }
        }.start();
        return future;
    }
}

class RealData implements Data {
    protected final String result;

    public RealData(String para) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; ++i) {
            sb.append(para);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
        }
        result = sb.toString();
    }

    @Override
    public String getResult() {
        return result;
    }
}
