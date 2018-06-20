package nl.nonmagna.buffer;

import nl.nonmagna.exception.BufferFullException;

public interface Buffer<T> {
    public void add(T element) throws BufferFullException;
    public T poll();
    public int size();
}
