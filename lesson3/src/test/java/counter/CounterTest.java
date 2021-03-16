package counter;

import org.junit.jupiter.api.Test;
import java.util.concurrent.CountDownLatch;
import static org.junit.jupiter.api.Assertions.*;

class CounterTest {

    @Test
    void increase() {
        int count  = 5;
        int THREADS_COUNT = 2;
        Counter counter = new Counter();
        final CountDownLatch cdl = new CountDownLatch(THREADS_COUNT);
        for (int i = 0; i < THREADS_COUNT; i++) {
            new Thread(() -> {
                    for (int j = 0; j < count; j++) {
                        try {
                            counter.increase();
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    cdl.countDown();
                }).start();
        }
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(THREADS_COUNT * count, counter.getCounter());
    }
}