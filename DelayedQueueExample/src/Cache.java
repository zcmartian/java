import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cache<K, V> {
	private static final Logger LOG = Logger.getLogger(Cache.class.getName());

	private ConcurrentMap<K, V> cacheObjMap = new ConcurrentHashMap<K, V>();

	private DelayQueue<DelayItem<Pair<K, V>>> q = new DelayQueue<DelayItem<Pair<K, V>>>();

	private Thread daemonThread;

	public Cache() {

		Runnable daemonTask = new Runnable() {
			public void run() {
				System.out.println(System.currentTimeMillis() + Thread.currentThread().getName() + " start!");
				daemonCheck();
			}
		};

		daemonThread = new Thread(daemonTask);
		daemonThread.setDaemon(true);
		daemonThread.setName("Cache Daemon");
		daemonThread.start();
	}

	private void daemonCheck() {

		if (LOG.isLoggable(Level.INFO))
			LOG.info("cache service started.");

		for (;;) {
			try {
				DelayItem<Pair<K, V>> delayItem = q.take();
				if (delayItem != null) {
					// ��ʱ������
					Pair<K, V> pair = delayItem.getItem();
					{
						LOG.info("cacheObjMap.remove.");
						cacheObjMap.remove(pair.first, pair.second); // compare
																	 // and
																	 // remove
					}

				}
				else
				{
					LOG.info("q.take() block!.");
				}
			} catch (InterruptedException e) {
				if (LOG.isLoggable(Level.SEVERE))
					LOG.log(Level.SEVERE, e.getMessage(), e);
				break;
			}
		}

		if (LOG.isLoggable(Level.INFO))
			LOG.info("cache service stopped.");
		else
			LOG.info("Log is not loggable.");
	}

	// ��ӻ������
	public void put(K key, V value, long time, TimeUnit unit) {
		V oldValue = cacheObjMap.put(key, value);
		if (oldValue != null) {
			q.remove(key);
		}

		long nanoTime = TimeUnit.NANOSECONDS.convert(time, unit);
		q.put(new DelayItem<Pair<K, V>>(new Pair<K, V>(key, value), nanoTime));
	}

	public V get(K key) {
		return cacheObjMap.get(key);
	}

	// ������ں���
	public static void main(String[] args) throws Exception {
		Cache<Integer, String> cache = new Cache<Integer, String>();
		cache.put(1, "aaaa", 3, TimeUnit.SECONDS);
		System.out.println(System.currentTimeMillis() + Thread.currentThread().getName() + " start!");
		Thread.sleep(1000 * 2);
		{
			String str = cache.get(1);
			System.out.println(str);
		}

		Thread.sleep(1000 * 2);
		{
			String str = cache.get(1);
			System.out.println(str);
		}
	}
}