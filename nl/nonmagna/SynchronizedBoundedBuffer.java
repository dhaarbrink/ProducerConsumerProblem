package nl.nonmagna;

import nl.nonmagna.exception.BufferFullException;

public class SynchronizedBoundedBuffer<T> {
    private BoundedBuffer<T> buffer;

    public SynchronizedBoundedBuffer(BoundedBuffer<T> buffer) {
        this.buffer = buffer;
    }

    public synchronized void add(T element) {
        try {
            buffer.add(element);
        } catch (BufferFullException e) {
            System.out.println("Buffer full, waiting for consumer");
            try {
                wait();
                add(element);
                return;
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
        notify();

        System.out.println("Added, new buffer size: "+ buffer.size());
    }

    public synchronized T poll() {
        T element = buffer.poll();
        if (element == null) {
            System.out.println("Buffer empty, waiting for producer");
            try {
                wait();
                return poll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notify();

        System.out.println("Removed, new buffer size: " + buffer.size());

        return element;
    }

    public String toString() {
        return buffer.toString();
    }
}
