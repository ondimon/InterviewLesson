package counter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private long counter = 0L;
    private Lock lock;

    public Counter() {
        this.lock = new ReentrantLock();
    }

    public void increase() {
        try {
            lock.lock();
            counter ++;
        }finally {
            lock.unlock();
        }
    }

    public long getCounter() {
        return counter;
    }
}
