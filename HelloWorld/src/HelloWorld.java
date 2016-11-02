import java.util.ArrayDeque;

public class HelloWorld {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Hello world!");
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int result = -1 & 4;
        System.out.println(deque.size());
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        deque.addLast(4);
        deque.pollFirst();
        deque.pollLast();
        System.out.println(deque.toString());
    }

}
