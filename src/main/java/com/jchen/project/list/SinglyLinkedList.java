package com.jchen.project.list;

public class SinglyLinkedList<T> implements IList<T> {

    private int size;
    Node<T> head;

    //creates empty list
    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    //convert the array to list
    public SinglyLinkedList(T[] arr) {
        addAll(arr);
    }

    @Override
    public T getFront() {
        if (size == 0) {
            return null;
        }
        return head.val;
    }

    @Override
    public T getLast() {

        if (size == 0) {
            return null;
        }

        Node<T> curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        return curr.val;
    }

    @Override
    public boolean add(T value) {
        return add(size, value);
    }

    @Override
    public boolean add(int idx, T value) {

        if (idx > size || idx < 0) {
            return false;
        }

        Node<T> nd = new Node<>(value);

        //insert at position 0 or the head
        //get the the index and insert and then reconnect it
        if (idx == 0) {
            nd.next = head;
            head = nd;
            size++;
            return true;
        }

        //insert last/end
        //insert middle
        Node curr = head;
        while (idx > 0 && curr != null) {
            curr = curr.next;
            idx--;
        }
        nd.next = curr.next;
        curr.next = nd;
        size++;
        return true;
    }

    @Override
    public boolean addAll(T[] value) {
        //empty array , dont need to add
        if (value.length == 0) {
            return false;
        }

        Node curr;

        //if there's notthing the start
        if (size == 0) {
            Node<T> nd = new Node<>(value[0]);
            head = nd;
            curr = head;
            size++;
            for (int i = 1; i < value.length; i++) {
                nd = new Node<>(value[i]);
                curr.next = nd;
                curr = curr.next;
                size++;
            }
            return true;
        }

        //if there's something, get till the end of that list and then add it

        return true;
    }

    @Override
    public boolean addFirst(T value) {
        Node nd = new Node(value);
        nd.next = head;
        head = nd;
        size++;
        return true;
    }

    @Override
    public boolean addLast(T value) {
        Node nd = new Node(value);
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = nd;
        size++;
        return true;
    }

    @Override
    public T get(int idx) {
        if (idx == 0) {
            return head.val;
        }

        Node<T> curr = head;
        while (idx > 0) {
            curr = curr.next;
            idx--;
        }
        return curr.val;
    }

    @Override
    public boolean remove(T value) {

        //empty list , notthing to remove
        if (size == 0) return false;

        //find it then remove it
        //return true;
        if (head.val == value) {
            head = head.next;
            size--;
            return true;
        }

        Node curr = head;
        while (curr.next != null) {
            if (value == curr.next.val) {
                /// not finish yet ,will do tmr
                curr.next = curr.next.next;
                size--;
                return true;
            }
            curr = curr.next;
        }

        //cant find it ,so return false;
        return false;
    }

    @Override
    public void clear() {
        //need to set everything to null
        while (head != null) {
            Node curr = head.next;
            head = null;
            head = curr;
        }
        size = 0;
    }

    @Override
    public boolean contains(T value) {

        if (head.val == value) {
            return true;
        }

        Node curr = head;
        while (curr.next != null) {

            if (curr.val == value) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        //should use string builder
        StringBuilder result = new StringBuilder();

        Node curr = head;
        for (int i = 0; i < size; i++) {
            result.append(curr.val);
            curr = curr.next;
        }

        return result.toString();
    }
}
