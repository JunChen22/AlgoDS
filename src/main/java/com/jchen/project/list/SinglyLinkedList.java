package com.jchen.project.list;

public class SinglyLinkedList<T> implements IList<T> {

    int size;
    Node head;

    //creates empty list
    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    //convert the array to list
    public SinglyLinkedList(T[] arr) {

        for(int i = 0; i<arr.length;i++){
            add(arr[i]);
        }
    }

    @Override
    public Node getFront() {
        return head;
    }

    @Override
    public Node getLast() {

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        return curr;
    }

    @Override
    public boolean add(T value) {

        Node<T> nd = new Node<>(value);

        if (head == null) {
            head = nd;
            size++;
            return true;
        }

        Node curr = head;

        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = nd;
        size++;
        return true;
    }

    @Override
    public boolean remove(T value) {
        //find it then remove it
        //return true;
        Node curr = head;

        while(curr.next!=null){
            if(value == curr.val){
                return true;
            }
            curr = curr.next;
        }

        //cant find it ,so return false;
        return false;
    }

    @Override
    public boolean addAll(T[] value) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(T value) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public  T[] toArray(T[] value) {
        return null;
    }
}
