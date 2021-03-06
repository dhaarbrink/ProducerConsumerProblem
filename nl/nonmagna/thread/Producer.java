package nl.nonmagna.thread;

import nl.nonmagna.buffer.SynchronizedBuffer;

import java.util.Random;
import java.util.UUID;

import static java.lang.Thread.sleep;

public class Producer implements Runnable {
    private SynchronizedBuffer<String> buffer;

    public Producer(SynchronizedBuffer<String> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String randString = UUID.randomUUID().toString();
                buffer.add(randString);

                System.out.println("Producer added to buffer");

                sleep(new Random().nextInt(10) * 1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted! " + e.getMessage());
            }
        }
    }
}
