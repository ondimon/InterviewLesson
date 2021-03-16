package pingpong;

public class PingPong {
    private final Object monitor = new Object();
    private volatile String currentWord;
    private final int COUNT = 5;

    public PingPong(String currentWord) {
        this.currentWord = currentWord;
    }

    public void print(String printWord, String nextWord) {
        synchronized (monitor) {
            try {
                for ( int i = 0; i < COUNT; i++ ) {
                    while (currentWord != printWord) {
                        monitor.wait();
                    }
                    System.out.println(printWord);
                    currentWord = nextWord;
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
