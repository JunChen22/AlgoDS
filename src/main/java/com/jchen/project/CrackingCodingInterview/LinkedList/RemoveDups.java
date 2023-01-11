package com.jchen.project.CrackingCodingInterview.LinkedList;

import java.util.HashSet;
import java.util.Set;


public class RemoveDups {

    class LinkedListNode {
        int data;
        LinkedListNode next;
        LinkedListNode prev;

        public LinkedListNode() {
            this.next = null;
        }
    }

    /*
        1. create a hash set
        2. store all nodes in set
        3. if existed, then skip to next node.

        Time: O(N) N is the number of elements in the linked list
        Space: O(N) number of elements if they all unique
     */
    public void solution(LinkedListNode node) {
        Set<Integer> set = new HashSet<Integer>();
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
    public void withoutBuffer(LinkedListNode head) {
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
}
