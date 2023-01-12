package com.jchen.project.data_structures.interfaces;

public interface IStack<T> {
    public boolean push(T value);
    public T pop();
    public boolean remove(T value);
    public void clear();
    public boolean contains(T value);
    public int size();
    public boolean validate();

}
