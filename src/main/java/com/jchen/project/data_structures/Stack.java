package com.jchen.project.data_structures;

import com.jchen.project.data_structures.interfaces.IStack;

public interface Stack<T> extends IStack<T> {
    // implement with queue
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
        @Override
        public boolean push(T value) {
            return false;
        }

        @Override
        public T pop() {
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
            return "ArrayStack{}";
        }
    }

    // implemtn with linked list
    public static class LinkedStack<T> implements Stack<T> {
        @Override
        public boolean push(T value) {
            return false;
        }

        @Override
        public T pop() {
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
            return "LinkedStack{}";
        }
    }
}
