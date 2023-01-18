package com.jchen.project.data_structure.interfaces;

public interface IList<T> {

    public boolean add(T value);

    public boolean add(int idx, T value);

    public boolean addAll(T[] value);

    public boolean addFirst(T value);

    public boolean addLast(T value);

    public boolean remove(T value);

    public void clear();

    public boolean contains(T value);

    public int size();

    public T get(int idx);

    public T getFront();

    public T getLast();

    public String toString();
}
