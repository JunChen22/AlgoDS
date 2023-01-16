package com.jchen.project.CrackingCodingInterview;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {
    public static class LinkedListNode {
        public int data;
        public LinkedListNode next;
        public LinkedListNode prev;

        public LinkedListNode() {
            this.next = null;
            this.prev = null;
        }
    }

    /*
        1. create a hash set
        2. store all nodes in set
        3. if existed, then skip to next node.

        Time: O(N) N is the number of elements in the linked list
        Space: O(N) number of elements if they all unique
     */
    public void removeDups(LinkedListNode node) {
        Set<Integer> set = new HashSet<>();
        LinkedListNode previous = null;
        while(node != null) {
            if(set.contains(node.data)) {
                previous.next = node.next;
            } else {
                set.add(node.data);
                previous = node;
            }
            node = node.next;   // update
        }
    }


    /*
        1. Using two pointer, one is current and one is to iterate the sub linked list
        2. go through the list
        3. search for duplicated node, if same as current node, removes it

        Time: O(N^2) needs to go through all nodes in worst case
        Space: 1
     */
    public void removeDupsNoBuffer(LinkedListNode head) {
        LinkedListNode current = head;
        while(current != null) {
            LinkedListNode runner = current;
            while(runner.next != null) {
                if(runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    /*
        1. if size is known, iterates (size - kth) times.
        Time: O(N) N is the number of elements
        Space:
    */
    public LinkedListNode ReturnKthtoLastSizeKnown(LinkedListNode head, int size, int kth) {
        LinkedListNode node = head;
        for(int i = 0; i < size - kth; i++) {
            node = node.next;
        }
        return node;
    }

    // TODO:
    public void ReturnKthKthRecurive() {

    }

    /*
        1. two pointer
        2. off set the one of the pointer by kth
        3. move both pointer at the same pace till one hit the end
        4. return the other pointer
     */
    public LinkedListNode ReturnKthKthIterative(LinkedListNode head, int kth) {
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;
        for (int i = 0; i < kth; i++) {
            if(p1 == null) return null;
            p1 = p1.next;
        }

        while(p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }


    /*

     */
    public void deleteMiddleNode(LinkedListNode head) {

    }




    /*

     */
    public LinkedListNode partition(LinkedListNode head, int x) {

        return head;
    }



    /*

     */
    public LinkedListNode SumList(LinkedListNode l1, LinkedListNode l2) {

        return l1;
    }





    /*
        Palindrome - same word but backward
        1. reverse the linked list
        2. compare the two linked list
     */
    public boolean isPalindrome(LinkedListNode head) {

        return true;
    }

    public LinkedListNode reverse(LinkedListNode head) {
        return head;
    }

    public boolean isEqual(LinkedListNode l1, LinkedListNode l2){
        return true;
    }

    public boolean isPalindromeIterative(LinkedListNode head) {
        return true;
    }

    public boolean isPalindromeRecursive(LinkedListNode head) {
        return true;
    }



    /*

     */
    public LinkedListNode Intersection(LinkedListNode l1, LinkedListNode l2) {

        return l1;
    }



    /*

     */
    public LinkedListNode loopDetection(LinkedListNode head) {
        return head;
    }
}
