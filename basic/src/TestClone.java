/**
 * Created by mars on 2017/1/24.
 */
class AClass implements Cloneable {
    public int a;

    public AClass(int a) {
        this.a = a;
    }

    public void change() {
        a += 12;
    }

    public String toString() {
        return "A Value is " + this.a;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

// 定义一个clone类，里面包含了AClass的对象引用
class BClass implements Cloneable {
    public int a = 12;
    public AClass obj = new AClass(11);

    public Object clone() {
        BClass object = null;
        try {
            object = (BClass) super.clone();
            object.obj = (AClass) obj.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        return object;
    }
}

public class TestClone {
    public static void main(String args[]) {
        BClass class1 = new BClass();
        class1.a = 15;

        System.out.println(class1.a);
        System.out.println(class1.obj);
        BClass class2 = (BClass) class1.clone();
        class2.a = 22;
        class2.obj.change();
        System.out.println(class1.a);
        System.out.println(class1.obj);
        System.out.println(class2.a);
        System.out.println(class2.obj);
    }
}
