package com.jchen.project.data_structure;

import com.jchen.project.data_structure.interfaces.IList;

public interface List<T> extends IList<T> {

    // TODO:
    public static class ArrayList<T> implements List<T> {

        private static final int MINIMUM_SIZE = 1024;

        private int size = 0;
        private T[] array = (T[]) new Object[MINIMUM_SIZE];

        @Override
        public boolean add(T value) {
            return false;
        }

        @Override
        public boolean add(int idx, T value) {
            return false;
        }

        @Override
        public boolean addAll(T[] value) {
            return false;
        }

        @Override
        public boolean addFirst(T value) {
            return false;
        }

        @Override
        public boolean addLast(T value) {
            return false;
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
        public T get(int idx) {
            return null;
        }

        @Override
        public T getFront() {
            return null;
        }

        @Override
        public T getLast() {
            return null;
        }
    }

    public static class SinglyLinkedList<T> implements List<T> {

        private static class Node<T> {
            private T value = null;
            private Node<T> next = null;
            private Node(T x) {
                this.value = x;
            }
        }
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
            return head.value;
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

            return curr.value;
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
            //get the index and insert and then reconnect it
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
            //empty array , don't need to add
            if (value.length == 0) {
                return false;
            }

            Node curr;

            //if there's nothing the start
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
                return head.value;
            }

            Node<T> curr = head;
            while (idx > 0) {
                curr = curr.next;
                idx--;
            }
            return curr.value;
        }

        @Override
        public boolean remove(T value) {

            //empty list , nothing to remove
            if (size == 0) return false;

            //find it then remove it
            //return true;
            if (head.value == value) {
                head = head.next;
                size--;
                return true;
            }

            Node curr = head;
            while (curr.next != null) {
                if (value == curr.next.value) {
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

            if (head.value == value) {
                return true;
            }

            Node curr = head;
            while (curr.next != null) {

                if (curr.value == value) {
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
                result.append(curr.value);
                curr = curr.next;
            }

            return result.toString();
        }
    }

    public static class DoublyLinkedList<T> implements List<T> {

        private static class Node<T> {
            private T value = null;
            private Node<T> prev = null;
            private Node<T> next = null;
            private Node(T x) {
                this.value = x;
            }
        }

        private int size;
        Node<T> head;

        public DoublyLinkedList() {
            head = null;
            size = 0;
        }

        public DoublyLinkedList(T[] arr) {
            addAll(arr);
        }

        @Override
        public T getFront() {
            if (size == 0) {
                return null;
            }
            return head.value;
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

            return curr.value;
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
            //get the index and insert and then reconnect it
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
            //empty array , don't need to add
            if (value.length == 0) {
                return false;
            }

            Node curr;

            //if there's nothing the start
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
                return head.value;
            }

            Node<T> curr = head;
            while (idx > 0) {
                curr = curr.next;
                idx--;
            }
            return curr.value;
        }

        @Override
        public boolean remove(T value) {

            //empty list , nothing to remove
            if (size == 0) return false;

            //find it then remove it
            //return true;
            if (head.value == value) {
                head = head.next;
                size--;
                return true;
            }

            Node curr = head;
            while (curr.next != null) {
                if (value == curr.next.value) {
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

            if (head.value == value) {
                return true;
            }

            Node curr = head;
            while (curr.next != null) {

                if (curr.value == value) {
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
                result.append(curr.value);
                curr = curr.next;
            }

            return result.toString();
        }
    }
}
