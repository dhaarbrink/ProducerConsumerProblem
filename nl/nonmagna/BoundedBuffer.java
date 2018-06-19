package nl.nonmagna;

import nl.nonmagna.exception.BufferFullException;

import java.util.ArrayList;
import java.util.List;

public class BoundedBuffer<T> {
    private final int maxBufferSize;
    private List<T> buffer = new ArrayList<T>();

    public BoundedBuffer(int bufferSize) {
        this.maxBufferSize = bufferSize;
    }

    public void add(T element) throws BufferFullException {
        if (buffer.size() >= maxBufferSize) {
            throw new BufferFullException();
        }

        buffer.add(element);
    }

    public T poll() {
        if (buffer.size() == 0) {
            return null;
        }

        T element = buffer.get(buffer.size() - 1);
        buffer.remove(element);
        return element;
    }

    public int size() {
        return buffer.size();
    }

    @Override
    public String toString() {
        return buffer.toString();
    }
}
