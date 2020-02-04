package com.jchen.project.list;

public class Node<T> {

    T val;
    Node next;
    Node prev;

    Node(T x) {
        val = x;
        next = null;
        prev = null;
    }
}
