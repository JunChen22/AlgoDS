package com.jchen.project.data_structure;

import com.jchen.project.data_structure.interfaces.IQueue;

import java.util.HashSet;
import java.util.Set;

public interface Queue<T> extends IQueue<T> {

    // implement with stack TODO:
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

        private static final int MINIMUM_SIZE = 1024;

        private T[] array = (T[]) new Object[MINIMUM_SIZE];
        private int lastIndex = 0;
        private int firstIndex = 0;


        @Override
        public boolean offer(T value) {
            if (size() >= array.length)
                grow(size());

            array[lastIndex % array.length] = value;
            lastIndex++;
            return true;
        }

        @Override
        public T poll() {
            int size = lastIndex - firstIndex;
            if (size < 0) return null;

            T t = array[firstIndex % array.length];
            array[firstIndex % array.length] = null;
            firstIndex++;

            size = lastIndex - firstIndex;
            if (size <= 0) {
                lastIndex = 0;
                firstIndex = 0;
            }

            int shrinkSize = array.length/2;
            if (shrinkSize >= MINIMUM_SIZE && size < shrinkSize)
                shrink();

            return t;
        }

        @Override
        public T peek() {
            return array[firstIndex % array.length];
        }

        @Override
        public boolean remove(T value) {
            for (int i = 0; i < array.length; i++) {
                T obj = array[i];
                if (obj.equals(value)) {
                    return remove(i);
                }
            }
            return false;
        }

        private boolean remove(int index) {

            if (index < 0 || index >= array.length) return false;
            if (index == firstIndex) return (poll() != null);

            int adjIndex = index % array.length;
            int adjLastIndex = (lastIndex - 1) % array.length;
            if (adjIndex != adjLastIndex) {
                System.arraycopy(array, index + 1, array, index, (array.length - (index + 1)));

                if (adjIndex < firstIndex) {

                    // Wrapped around array
                    array[array.length - 1] = array[0];
                    System.arraycopy(array, 1, array, 0, firstIndex - 1);
                }
            }

            array[adjLastIndex] = null;

            int shrinkSize = array.length/2;
            if (shrinkSize >= MINIMUM_SIZE && size() < shrinkSize)
                shrink();

            lastIndex--;
            return true;
        }


        // Double the size of the underlying array and to rearrange to make sequential
        private void grow(int size) {
            int growSize = (size * 2);
            T[] temp = (T[]) new Object[growSize];

            // Since the array can wrap around, make sure you grab the first chunk
            int adjLast = lastIndex % array.length;
            if (adjLast > 0 && adjLast <= firstIndex) {
                System.arraycopy(array, 0, temp, array.length-adjLast, adjLast);
            }

            // Copy the remaining
            System.arraycopy(array, firstIndex, temp, 0, array.length - firstIndex);
            array = null;
            array = temp;
            lastIndex = (lastIndex - firstIndex);
            firstIndex = 0;
        }


        // Shrink the array by 50% and rearrange to make sequential
        private void shrink() {
            int shrinkSize = array.length / 2;
            T[] temp = (T[]) new Object[shrinkSize];

            // Since the array can wrap around, make sure you grab the first chunk
            int adjLast = lastIndex % array.length;
            int endIndex = (lastIndex > array.length)? array.length : lastIndex;
            if (adjLast <= firstIndex) {
                System.arraycopy(array, 0, temp, array.length - firstIndex, adjLast);
            }

            // Copy the remaining
            System.arraycopy(array, firstIndex, temp, 0, endIndex - firstIndex);
            array = null;
            array = temp;
            lastIndex = (lastIndex - firstIndex);
            firstIndex = 0;
        }

        @Override
        public void clear() {
            firstIndex = 0;
            lastIndex = 0;
        }

        @Override
        public boolean contains(T value) {
            for (int i = 0; i < array.length; i++) {
                T obj = array[i];
                if (obj.equals(value)) return true;
            }
            return false;
        }

        @Override
        public int size() {
            return lastIndex - firstIndex;
        }

        @Override
        public boolean validate() {
            if (size() == 0) return true;

            int localSize = 0;

            int realFirst = firstIndex;
            if (firstIndex > array.length)
                realFirst = firstIndex % array.length;

            int realLast = lastIndex;
            if (lastIndex > array.length)
                realLast = lastIndex % array.length;

            for (int i = 0; i < array.length; i++) {
                T t = array[i];
                if ((realFirst == realLast) ||
                    (realFirst < realLast && (i >= realFirst && i < realLast)) ||
                    (realLast < realFirst && (i < realLast || i >= realFirst))

                ) {
                    if ( t == null) return false;

                    localSize++;
                } else {
                    if (t != null) return false;
                }
            }

            return localSize == size();
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (int i = lastIndex - 1; i >= firstIndex; i--) {
                builder.append(array[i%array.length]).append(", ");
            }
            return builder.toString();
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


        // queue  working backward.    head(last)  -> tail(first to be out)
        private boolean add(Node<T> node) {
            if(head == null) {
                head = node;
                tail = node;
            } else {
                Node<T> oldHead = head;
                head = node;
                node.next = oldHead;
                oldHead.prev = node;
            }
            size++;
            return true;
        }

        @Override
        public T poll() {
            T result = null;
            if (tail != null) {
                result = tail.value;

                Node<T> prev = tail.prev;
                if (prev != null) {
                    prev.next = null;
                    tail = prev;
                } else { // if just one element
                    head = null;
                    tail = null;
                }
                size--;
            }
            return result;
        }

        @Override
        public T peek() {
            return (tail != null)? tail.value : null;
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
            Set<T> keys = new HashSet<T>();
            Node<T> node = head;
            if (node != null) {
                keys.add(node.value);
                if (node.prev != null) return false;
                Node<T> child = node.next;
                while (child != null) {
                    if(!validate(child, keys)) return false;
                    child = child.next;
                }
            }
            return keys.size() == size();
        }


        private boolean validate(Node<T> node, Set<T> keys) {
            if (node.value == null) return false;
            keys.add(node.value);

            Node<T> child = node.next;
            if (child != null) {
                if (!child.prev.equals(node)) return false;
                if (!validate(child, keys)) return false;
            } else {
                if (!node.equals(tail)) return false;
            }
            return true;
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
