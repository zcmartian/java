import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentHashMapExample {

    public static void main(String[] args) throws Exception {
        ConcurrentMap<String, String> concurrentMap = new ConcurrentHashMap<String, String>();
        concurrentMap.put("key", "value");

        for (int i = 0; i < 10; ++i) {
            ThreadModule mo = new ThreadModule(concurrentMap);
            mo.run();
            Thread.sleep(1000);
        }
    }

}
