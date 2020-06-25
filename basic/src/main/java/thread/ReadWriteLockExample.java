package thread;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        readWriteLock.readLock().lock();

        // multiple readers can enter this section
        // if not locked for writing, and not writers waiting
        // to lock for writing.

        readWriteLock.readLock().unlock();

        readWriteLock.writeLock().lock();

        // only one writer can enter this section,
        // and only if no threads are currently reading.

        readWriteLock.writeLock().unlock();

        // atomicreference
        String initialReference = "initial value referenced";

        AtomicReference<String> atomicStringReference = new AtomicReference<String>(initialReference);

        String newReference = "new value referenced";
        boolean exchanged = atomicStringReference.compareAndSet(initialReference, newReference);
        System.out.println("exchanged: " + exchanged);
        System.out.println("atomicStringReference: " + atomicStringReference.toString());

        exchanged = atomicStringReference.compareAndSet(initialReference, newReference);
        System.out.println("exchanged: " + exchanged);
    }

}
