package com.jchen.project.data_structure.interfaces;

public interface IStack<T> {
    public boolean push(T value);
    public T pop();
    public T peek();
    public boolean remove(T value);
    public void clear();
    public boolean contains(T value);
    public int size();
    public boolean validate();

}
