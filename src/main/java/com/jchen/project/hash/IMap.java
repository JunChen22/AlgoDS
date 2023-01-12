package com.jchen.project.hash;

public interface IMap<K,V> {
    public V put(K key, V value);
    public V get(K key);
    public V remove(K key);
    public void clear();
    public boolean contains(K key);
    public int size();
    public boolean validate();
}
