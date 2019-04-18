/**
 * Created by marszhou on 16/1/7.
 */
public class Client {
    public Data request(final String queryStr) {
        final Future future = new Future();

        new Thread() {
            public void run() {
                RealData realData = new RealData(queryStr);
                future.setRealData(realData);
            }
        }.start();
        return future;
    }
}
