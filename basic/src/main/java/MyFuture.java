/**
 * Created by marszhou on 16/1/7.
 */
public class MyFuture implements Data {
    protected RealData realData;
    protected boolean isReady;

    public synchronized void setRealData(RealData realData) {
        if (isReady) {
            return;
        }
        this.realData = realData;
        isReady = true;
        notifyAll();
    }

    @Override
    public synchronized String getResult() {
        while (!isReady) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        return realData.result;
    }
}
