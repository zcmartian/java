package jvm;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;



public class ProxyExample {
    interface ILogin {
        void Login();

        void Logout();
    }
    public static void main(String[] args) {
        RealLogin realLogin = new RealLogin();
        ILogin target = new ProxyLogin(realLogin);

        ClassLoader loader;
        Class[] interfaces;

        InvocationHandler handler;

        ILogin proxy = (ILogin) Proxy.newProxyInstance(target.getClass().getClassLoader(), new Class[]{ILogin.class},
                new TimerInvocationHandler(target));

        proxy.Login();
        proxy.Logout();
    }

    static class TimerInvocationHandler implements InvocationHandler {
        private Object target;

        public TimerInvocationHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            long begin = System.currentTimeMillis();

            Object retValue = method.invoke(target, args);
            long end = System.currentTimeMillis();
            System.out.println("时间差" + (end - begin) + "毫秒");
            return retValue;
        }
    }

    static class ProxyLogin implements ILogin {
        private RealLogin target;

        public ProxyLogin(RealLogin target) {
            this.target = target;
        }

        @Override
        public void Login() {
            long begin = System.currentTimeMillis();
            target.Login();
            long end = System.currentTimeMillis();
            System.out.println("时间差" + (end - begin) + "毫秒");
        }

        @Override
        public void Logout() {
            long begin = System.currentTimeMillis();
            target.Logout();
            long end = System.currentTimeMillis();
            System.out.println("时间差" + (end - begin) + "毫秒");
        }
    }

    static class RealLogin implements ILogin {

        @Override
        public void Login() {
            try {
                Thread.sleep(3200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("登录.....");
        }

        @Override
        public void Logout() {
            try {
                Thread.sleep(2200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("登出....");
        }

    }
}
