package com.jchen.project.data_structure.interfaces;

public interface IHeap<T> {

    public boolean add(T value);
    public T getHeadValue();
    public T removeHead();
    public T remove(T value);
    public void clear();
    public boolean contains(T value);
    public int size();
    public boolean validate();
}
