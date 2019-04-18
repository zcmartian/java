import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimerInvocationHandler implements InvocationHandler {
    private Object target;

    // ���췽��
    public TimerInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // TODO Auto-generated method stub
        long begin = System.currentTimeMillis();

        // ִ��Ŀ������еķ���
        Object retValue = method.invoke(target, args);
        // ����ʱ��
        long end = System.currentTimeMillis();
        // ����ʱ��
        System.out.println("�ķ�ʱ��" + (end - begin) + "����");
        return retValue;
    }

}
