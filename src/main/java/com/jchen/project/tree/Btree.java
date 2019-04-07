package com.jchen.project.tree;
/*Binary Tree
A tree whose elements have at most 2 children is called a binary tree.
Since each element in a binary tree can have only 2 children, we typically name
them the left and right child.

A Binary Tree node contains following parts.

1.Data
2.Pointer to left child
3.Pointer to right child

(https://www.geeksforgeeks.org/binary-tree-data-structure/)

Rules
1.There are at most 2^l nodes at level L of a binary tree. And at least 1 nodes.
2.There are at most 2^(2^(d+1) -1 nodes in a binary tree with depth d.
  and when it's least ,it is d amount of nodes, it would look like a snake
3.A binary tree with n nodes have depth at at least floor(logn) and have depth
  at most n-1.(give nodes,get depth)
4.A Binary Tree with L leaves has at least ceil(LogL) + 1 levels
5.In Binary tree where every node has 0 or 2 children, number of leaf nodes
  is always one more than nodes with two children.
*/

public class Btree<T> {

    public class Node<T> {

        T val;
        Node left;
        Node right;

        Node(T x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public Btree() {

    }
    /*
    //create a binary tree from a array
    public T makeTree(T[] arr) {

        Node<T> nd = new Node<T>();
        if (arr.length == 0){
            for (T item : arr) {

            }
        }
    }
    */
    public boolean add() {

        return false;
    }

    public Node remove() {

        return new Node(-1);
    }


    public boolean containtsRecursive() {
        return false;
    }

    public boolean containtsIterative() {
        return false;
    }

    // TODO: implement method to write tree in recoverable format to file
    void serialize() {

    }

    // TODO: implement method to read tree in from file
    void deserialize() {

    }

    //pre-order , curr, left then right
    public String toString() {
        return "";
    }
}
