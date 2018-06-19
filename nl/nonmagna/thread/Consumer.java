package nl.nonmagna.thread;

import nl.nonmagna.SynchronizedBoundedBuffer;

import java.util.Random;

public class Consumer implements Runnable {
    private SynchronizedBoundedBuffer<String> buffer;

    public Consumer(SynchronizedBoundedBuffer<String> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            String result = buffer.poll();

            System.out.println("Consumer result: " + result);

            try {
                Thread.sleep(new Random().nextInt(10) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
