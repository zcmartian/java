package thread;

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

    private static class ThreadModule implements Runnable {

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
}
