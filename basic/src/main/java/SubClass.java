/**
 * Created by mars on 2017/1/24.
 */
class Base {
    public static int a = 10;//1

    static {
        System.out.println("Static Init Base " + a);//2
        // System.out.println("Null Init " + b);
    }

    public int b = 20;//7

    public Base() {
        System.out.println("Init Base " + this.b);//8
    }
}

/**
 * 一级子类和基类包含的内容一样
 **/
class SuperClass extends Base {
    public static int a1 = getSuperStaticNumber();//3

    static {
        System.out.println("Static Init SuperClass" + a1);//4
    }

    public int b1 = getSuperInstanceNumber();//9

    public SuperClass() {
        System.out.println("Init SuperClass" + this.b1);//10
    }

    public static int getSuperStaticNumber() {
        System.out.println("Static member init");
        return 100;
    }

    public int getSuperInstanceNumber() {
        System.out.println("Instance member init");
        return 200;
    }
}

/**
 * 二级子类为测试该代码的驱动类
 */
public class SubClass extends SuperClass {
    public static int a2 = getStaticNumber();//5

    static {
        System.out.println("Static Init " + a2);//6
    }

    public int b2 = getInstanceNumber();//11

    public SubClass() {
        System.out.println("Init SubClass " + this.b2);//12
    }

    public static int getStaticNumber() {
        System.out.println("Static member init Sub");
        return 1000;
    }

    public static void main(String args[]) {
        new SubClass();
    }

    public int getInstanceNumber() {
        System.out.println("Instance member init Sub");
        return 2000;
    }
}
