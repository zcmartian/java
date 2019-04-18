import java.io.*;
import java.lang.reflect.Method;

/**
 * Created by mars on 16/11/2.
 */
public class SerializeObj implements Serializable {
    private int id;
    private String name;
    private transient int data;

    public SerializeObj(int id, String name, int data) {
        this.id = id;
        this.name = name;
        this.data = data;
    }

    public static void main(String[] args) {
        SerializeObj serializeObj = new SerializeObj(123, "456", 789);
        File file = new File("/Users/mars/Documents/out.ser");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(serializeObj);
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            SerializeObj serializeObj1 = null;
            try {
                serializeObj1 = (SerializeObj) ois.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(serializeObj1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Class clazz = SerializeObj.class;
        try {
            Method method = clazz.getDeclaredMethod("readObject", new Class<?>[]{ObjectInputStream.class});
            System.out.println(method.getModifiers());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeInt(data);
        System.out.println("session serialized");
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        data = ois.readInt();
        System.out.println("session deserialized");
    }

    @Override
    public String toString() {
        return "SerializeObj{" + "id=" + id + ", name='" + name + '\'' + ", data=" + data + '}';
    }
}
