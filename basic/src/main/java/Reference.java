/**
 * Created by mars on 2017/3/1.
 */
public class Reference {
    private int value;

    public Reference(int value) {
        this.value = value;
    }

    public static void main(String... args) {
        Reference reference = new Reference(100);

        System.out.println(reference);
        change(reference);
        System.out.println(reference);
    }

    private static void change(Reference ref) {
//        ref.setValue(200);
        ref = new Reference(200);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Reference{" +
                "value=" + value +
                '}';
    }
}
