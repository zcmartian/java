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
        // ����ʱ��
        long end = System.currentTimeMillis();
        System.out.println("�ķ�ʱ��" + (end - begin) + "����");
    }

    @Override
    public void Logout() {
        // TODO Auto-generated method stub
        long begin = System.currentTimeMillis();
        target.Logout();
        long end = System.currentTimeMillis();
        System.out.println("�ķ�ʱ��" + (end - begin) + "����");
    }

}
