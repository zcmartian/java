package thread;

import thread.MyRecursiveAction;

import java.util.concurrent.ForkJoinPool;

public class RecursiveActionExample {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        ForkJoinPool forkJoinPool = new ForkJoinPool(4);

        MyRecursiveAction myRecursiveAction = new MyRecursiveAction(24);

        forkJoinPool.invoke(myRecursiveAction);
    }

}
