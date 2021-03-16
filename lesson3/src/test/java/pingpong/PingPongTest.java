package pingpong;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PingPongTest {

    @Test
    void print() {
        PingPong printClass = new PingPong("Ping");
        Thread printPing = new Thread(() -> printClass.print("Ping", "Pong"));
        Thread printPong = new Thread(() -> printClass.print("Pong", "Ping"));
        printPing.start();
        printPong.start();
    }
}