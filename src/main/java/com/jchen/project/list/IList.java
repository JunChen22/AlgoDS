package com.jchen.project.list;

public interface IList<T>{

    public boolean add(T value);

    public boolean remove(T value);

    public boolean addAll(T[] value);

    public void clear();

    public boolean contains(T value);

    public int size();

    public T[] toArray(T[] value);

    public Node getFront();

    public Node getLast();
}
