package com.jchen.project.CrackingCodingInterview.LinkedList;

public class ReturnKthtoLast {

    class LinkedListNode {
        int data;
        LinkedListNode next;
        LinkedListNode prev;

        public LinkedListNode() {
            this.next = null;
        }
    }

    /*
        1. if size is known, iterates (size - kth) times.
        Time: O(N) N is the number of elements
        Space:
     */
    public LinkedListNode sizeKnown(LinkedListNode head, int size, int kth) {
        LinkedListNode node = head;
        for(int i = 0; i < size - kth; i++) {
            node = node.next;
        }
        return node;
    }

    // TODO:
    public void recurive() {

    }


    /*
        1. two pointer
        2. off set the one of the pointer by kth
        3. move both pointer at the same pace till one hit the end
        4. return the other pointer
     */
    public LinkedListNode iterative(LinkedListNode head, int kth) {
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
}
