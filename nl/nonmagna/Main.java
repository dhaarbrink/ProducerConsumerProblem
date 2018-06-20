package nl.nonmagna;

import nl.nonmagna.buffer.BoundedBuffer;
import nl.nonmagna.buffer.Buffer;
import nl.nonmagna.buffer.SynchronizedBuffer;
import nl.nonmagna.thread.Consumer;
import nl.nonmagna.thread.Producer;

public class Main {

    public static void main(String[] args) throws Exception {
        SynchronizedBuffer<String> buffer = new SynchronizedBuffer<>(new BoundedBuffer<>(10));

        Consumer consumer = new Consumer(buffer);
        Producer producer = new Producer(buffer);

        new Thread(consumer).start();
        new Thread(producer).start();

        while (true) {
            Thread.sleep(10000);
        }
    }
}
