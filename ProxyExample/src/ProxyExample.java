import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RealLogin realLogin = new RealLogin();
		ILogin target = new ProxyLogin(realLogin);

		ClassLoader loader;
		Class[] interfaces;

		InvocationHandler handler;

		ILogin proxy = (ILogin) Proxy.newProxyInstance(target.getClass().getClassLoader(), new Class[] { ILogin.class },
				new TimerInvocationHandler(target));

		proxy.Login();
		proxy.Logout();
	}

}
