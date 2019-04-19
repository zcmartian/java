import java.util.concurrent.ConcurrentMap;

public class ThreadModule implements Runnable {

    static ConcurrentMap<String, String> concurrentMap;

    public ThreadModule(ConcurrentMap<String, String> map) {
        concurrentMap = map;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        Object value = concurrentMap.get("key");
        System.out.println(value.toString());
    }
}
