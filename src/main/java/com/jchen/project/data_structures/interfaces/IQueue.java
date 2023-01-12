package com.jchen.project.data_structures.interfaces;

public interface IQueue<T> {
    /*
        Add a value to the beginning of the queue.
        @param value to add to queue.
        @return True if added to queue.
     */
    public boolean offer(T value);
    public T poll();
    public T peek();
    public boolean remove(T value);
    public void clear();
    public boolean contains(T value);
    public int size();
    public boolean validate();
}
