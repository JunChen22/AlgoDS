package com.jchen.project.data_structure.interfaces;

public interface ISet<T> {

    public boolean add(T value);
    public boolean remove(T value);
    public void clear();
    public boolean contains(T value);
    public int size();
    public boolean valiudate();
}
