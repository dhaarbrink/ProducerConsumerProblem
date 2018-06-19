package nl.nonmagna.thread;

import nl.nonmagna.BoundedBuffer;

import static java.lang.Thread.sleep;

public class Inspector implements Runnable {
    private final BoundedBuffer<String> buffer;
    private final Producer producer;
    private final Consumer consumer;

    public Inspector(BoundedBuffer<String> buffer, Producer producer, Consumer consumer) {
        this.buffer = buffer;
        this.producer = producer;
        this.consumer = consumer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                break;
            }

//            System.out.println("** ****** SYSTEM REPORT ***********");
//            System.out.println("** Buffer size: " + buffer.size());
//            System.out.println("** Producer state: " + producer.getState().toString());
//            System.out.println("** Consumer state: " + consumer.getState().toString());
            System.out.println("");
        }
    }
}
