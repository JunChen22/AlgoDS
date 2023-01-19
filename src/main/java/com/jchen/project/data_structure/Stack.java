package com.jchen.project.data_structure;

import com.jchen.project.data_structure.interfaces.IStack;

import java.util.Arrays;
import java.util.Queue;

public interface Stack<T> extends IStack<T> {

    // implement with queue TODO:
    public static class QueueStack<T> implements Stack<T> {
        @Override
        public boolean push(T value) {
            return false;
        }

        @Override
        public T pop() {
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
            return "QueueStack{}";
        }
    }

    // implement with array
    public static class ArrayStack<T> implements Stack<T> {

        private static final int MINIMUM_SIZE = 1024;

        private T[] array = (T[]) new Object[MINIMUM_SIZE];
        private int size = 0;

        @Override
        public boolean push(T value) {
            if (size >= array.length) grow();
            size++;
            array[size] = value;
            return true;
        }

        // Grow the array by 100%
        private void grow() {
            int growSize = size * 2;
            array = Arrays.copyOf(array, growSize);
        }

        // Shrink the array by 50%
        private void shrink() {
            int shrinkSize = size/2;
            array = Arrays.copyOf(array, shrinkSize);
        }

        @Override
        public T pop() {
            if (size <= 0) return null;

            T top = array[size];
            array[size] = null;
            size--;

            if (size >= MINIMUM_SIZE && 2 * size < array.length) shrink();

            return top;
        }

        @Override
        public T peek() {
            return array[size];
        }

        @Override
        public boolean remove(T value) {
            for (int i = 0; i < size; i++) {
                T obj = array[i];
                if (obj.equals(value)) {
                    return (remove(i));
                }
            }
            return false;
        }

        private boolean remove(int index) {

            if (index != size-1) {
                // Shift the array down one spot
                System.arraycopy(array, index + 1, array, index, size - index);
            }
            array[size] = null;
            size--;

            if (size >= MINIMUM_SIZE && 2 * size < array.length) shrink();
            return true;
        }

        @Override
        public void clear() {
            size = 0;
        }

        @Override
        public boolean contains(T value) {
            for (int i = 0; i < size; i++) {
                T obj = array[i];
                if (obj.equals(value))
                    return true;
            }
            return false;
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public boolean validate() {
            int localSize = 0;
            for (int i = 0; i < array.length; i++) {
                T t = array[i];
                if (i < size) {
                    if (t == null) return false;
                    localSize++;
                } else {  // at the end check
                    if (t != null) return false;
                }
            }
            return (localSize == size);
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (int i = size - 1; i >= 0; i--) {
                builder.append(array[i]).append(", ");
            }
            return builder.toString();
        }

        public Queue<T> toLifoQueue() {
            return null;
        }
    }

    // implement with linked list
    public static class LinkedStack<T> implements Stack<T> {

        private static class Node<T> {
            private T value = null;
            private Node<T> above = null;
            private Node<T> below = null;

            private Node(T value) {
                this.value = value;
            }

            @Override
            public String toString() {
                return "value=" + value + " above=" + ((above != null) ? above.value : "NULL") + " below="
                        + ((below != null) ? below.value : "NULL");
            }
        }

        private Node<T> top = null;
        private int size = 0;

        public LinkedStack() {
            this.top = null;
            this.size = 0;
        }

        @Override
        public boolean push(T value) {
            return push(new Node<T>(value));
        }

        private boolean push(Node<T> node) {
            if (top == null) {
                top = node;
            } else {
                Node<T> oldTop = top;
                top = node;
                top.below = oldTop;
                oldTop.above = top;
            }

            size++;
            return true;
        }

        @Override
        public T pop() {
            if (top == null) return null;

            Node<T> nodeToRemove = top;
            top = nodeToRemove.below;
            if (top != null) top.above = null;

            T value = nodeToRemove.value;
            size--;
            return value;
        }

        @Override
        public T peek() {
            return top != null ? top.value : null;
        }

        @Override
        public boolean remove(T value) {
            // find the node
            Node<T> node = top;
            while (node != null && (!node.value.equals(value))) {
                node = node.below;
            }

            if (node == null) return false;
            return remove(node);
        }

        private boolean remove(Node<T> node) {
            Node<T> above = node.above;
            Node<T> below = node.below;

            if (above != null && below != null) {   // node is middle of stack
                above.below = below;
                below.above = above;
            } else if (above != null && below == null) { // node is at the bottome of stack
                above.below = null;
            } else if (above == null && below != null) {  // node is top of the stack
                below.above = null;
                top = below;
            } else {  // node is the only one in the stack
                top = null;
            }
            size--;
            return true;
        }

        @Override
        public void clear() {
            top = null;
            size = 0;
        }

        @Override
        public boolean contains(T value) {
            if (top == null) return false;
            Node<T> node = top;
            while (node != null) {
                if (node.value.equals(value)) return true;
                node = node.below;
            }
            return false;
        }

        @Override
        public int size() {
            return size;
        }

        // TODO:
        @Override
        public boolean validate() {
            return false;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            Node<T> node = top;
            while (node != null) {
                builder.append(node.value).append(", ");
                node = node.below;
            }
            return builder.toString();
        }
    }
}
