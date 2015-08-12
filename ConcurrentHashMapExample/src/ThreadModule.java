import java.util.concurrent.*;

public class ThreadModule implements Runnable {

	public ThreadModule(ConcurrentMap<String, String> map) {
		concurrentMap = map;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Object value = concurrentMap.get("key");
		System.out.println(value.toString());
	}

	static ConcurrentMap<String, String> concurrentMap;
}
