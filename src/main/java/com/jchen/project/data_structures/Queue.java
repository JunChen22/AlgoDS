package com.jchen.project.data_structures;

import com.jchen.project.data_structures.interfaces.IQueue;

public interface Queue<T> extends IQueue<T> {

    // implement with stack
    public static class StackQueue<T> implements Queue<T> {
        @Override
        public boolean offer(T value) {
            return false;
        }

        @Override
        public T poll() {
            return null;
        }

        @Override
        public T peek() {
            return null;
        }

        @Override
        public boolean remove(T value) {
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
            return 0;
        }

        @Override
        public boolean validate() {
            return false;
        }

        @Override
        public String toString() {
            return "StackQueue{}";
        }
    }

    // implement with array
    public static class ArrayQueue<T> implements Queue<T> {
        @Override
        public boolean offer(T value) {
            return false;
        }

        @Override
        public T poll() {
            return null;
        }

        @Override
        public T peek() {
            return null;
        }

        @Override
        public boolean remove(T value) {
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
            return 0;
        }

        @Override
        public boolean validate() {
            return false;
        }

        @Override
        public String toString() {
            return "ArrayQueue{}";
        }
    }

    // implement with linked list
    public static class LinkedQueue<T> implements Queue<T> {

        private static class Node<T> {
            private T value = null;
            private Node<T> prev = null;
            private Node<T> next = null;

            private Node(T value) {
                this.value = value;
            }

            @Override
            public String toString() {
                return "value=" + value + " previous=" + ((prev != null) ? prev.value : "NULL") + " next=" + ((next != null) ? next.value : "NULL");
            }
        }

        private Node<T> head;
        private Node<T> tail;
        private int size;

        public LinkedQueue() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        @Override
        public boolean offer(T value) {
            return add(new Node<T>(value));
        }
        private boolean add(Node<T> node) {
            if(head == null) {
                head = node;
                tail = node;
            } else {


            }

            return true;
        }

        @Override
        public T poll() {
            return null;
        }

        @Override
        public T peek() {
            return (tail != null)? tail.value: null;
        }

        @Override
        public boolean remove(T value) {
            Node<T> node = head;
            while(node != null) {
                if(node.value == value && (!node.value.equals(value))) {
                    node = node.next;
                }
            }
            if(node == null) return false;
            return remove(node);
        }

        private boolean remove(Node<T> node){
            if (node.equals(tail)) tail = node.prev;

            Node<T> prev = node.prev;
            Node<T> next = node.next;

            if(prev != null && next != null) { // node is in middle
                prev.next = next;
                next.prev = prev;
            } else if(prev != null && next == null) {// node is at tail
                prev.next = null;
            } else if(prev == null && next != null) { // node is at head
                next.prev = null;
                head = next;
            } else {
                // prev == null && next == null
                // node is one and only
                head = null;
            }
            size--;
            return true;
        }

        // let Java garbage collector deal with it.
        @Override
        public void clear() {
            head = null;
            size = 0;
        }

        @Override
        public boolean contains(T value) {
            if(head == null) return false;

            Node<T> node = head;
            while(node != null) {
                if(node.value.equals(value)) return true;
                node = node.next;
            }
            return false;
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public boolean validate() {
            return false;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            Node<T> node = head;
            while(node != null) {
                builder.append(node.value).append(", ");
                node = node.next;
            }
            return builder.toString();
        }
    }
}
