
public class RealLogin implements ILogin {

	@Override
	public void Login() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(3200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("登录系统.....");
	}

	@Override
	public void Logout() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(2200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("退出系统....");
	}

}
