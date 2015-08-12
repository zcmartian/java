
public class ProxyLogin implements ILogin {
	private RealLogin target;

	public ProxyLogin(RealLogin target) {
		this.target = target;
	}

	@Override
	public void Login() {
		// TODO Auto-generated method stub
		long begin = System.currentTimeMillis();
		target.Login();
		// 结束时间
		long end = System.currentTimeMillis();
		System.out.println("耗费时长" + (end - begin) + "毫秒");
	}

	@Override
	public void Logout() {
		// TODO Auto-generated method stub
		long begin = System.currentTimeMillis();
		target.Logout();
		long end = System.currentTimeMillis();
		System.out.println("耗费时长" + (end - begin) + "毫秒");
	}

}
