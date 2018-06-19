package nl.nonmagna;

import nl.nonmagna.thread.Consumer;
import nl.nonmagna.thread.Producer;

public class Main {

    public static void main(String[] args) throws Exception {
        SynchronizedBoundedBuffer<String> buffer = new SynchronizedBoundedBuffer<>(new BoundedBuffer<>(10));

        Consumer consumer = new Consumer(buffer);
        Producer producer = new Producer(buffer);

        new Thread(consumer).start();
        new Thread(producer).start();

        while (true) {
            Thread.sleep(10000);
        }
    }
}
