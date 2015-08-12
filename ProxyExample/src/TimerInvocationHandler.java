import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimerInvocationHandler implements InvocationHandler {
	private Object target;

	// 构造方法
	public TimerInvocationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		long begin = System.currentTimeMillis();

		// 执行目标对象中的方法
		Object retValue = method.invoke(target, args);
		// 结束时间
		long end = System.currentTimeMillis();
		// 计算时间
		System.out.println("耗费时长" + (end - begin) + "毫秒");
		return retValue;
	}

}
