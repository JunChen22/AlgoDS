package com.jchen.project.data_structure;

import com.jchen.project.data_structure.interfaces.ITree;

public interface Tree<T> extends ITree<T> {

    /*
     * A binary search tree (BST)
     * 1) The left subtree of a node contains only nodes with keys less than the node's key.
     * 2) The right subtree of a node contains only nodes with keys greater than the node's key.
     * 3) Both the left and right subtrees must also be binary search trees.
     */
    public static class BinarySearchTree<T extends Comparable<T>> implements Tree<T>{

        @Override
        public boolean add(T value) {
            return false;
        }

        @Override
        public T remove(T value) {
            return null;
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
    }

    /*
        A trie or prefix tree.
     */
    public static class Trie<T> implements Tree<T> {
        @Override
        public boolean add(T value) {
            return false;
        }

        @Override
        public T remove(T value) {
            return null;
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
    }
}
