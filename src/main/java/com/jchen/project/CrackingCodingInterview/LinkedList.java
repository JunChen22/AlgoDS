package com.jchen.project.CrackingCodingInterview;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LinkedList {
    public static class LinkedListNode {
        public int data;
        public LinkedListNode next;
        public LinkedListNode prev;

        public LinkedListNode(int data) {
            this.data = data;
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
       not given first or last node.

       copy the next node and delete the next node instead.
     */
    public boolean deleteMiddleNode(LinkedListNode node) {
        if (node == null || node.next == null) {
            return false;
        }

        LinkedListNode next = node.next;
        node.data = next.data;
        node.next = next.next;
        return true;
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
        LinkedListNode reversed = reverse(head);
        return isEqual(head, reversed);
    }

    public LinkedListNode reverse(LinkedListNode node) {
        LinkedListNode head = null;

        while (node != null) {
            LinkedListNode n = new LinkedListNode(node.data);
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }

    public boolean isEqual(LinkedListNode l1, LinkedListNode l2){

        while (l1 != null && l2 != null) {
            if (l1.data != l2.data) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null && l2 == null;
    }




    public boolean isPalindromeIterative(LinkedListNode head) {
        LinkedListNode fast = head;
        LinkedListNode slow = head;

        Stack<Integer> stack = new Stack<Integer>();

        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        // has odd number of elements, so skip the middle element
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            int top = stack.pop().intValue();

            if (top != slow.data) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    // TODO:
    public boolean isPalindromeRecursive(LinkedListNode head) {
        return true;
    }



    /*
        time: O(A + B) where A and B is the length of the two linked list
        space: O(1)
     */
    public LinkedListNode Intersection(LinkedListNode l1, LinkedListNode l2) {
        if (l1 == null || l2 == null) return null;

        Result result1 = getTailAndSize(l1);
        Result result2 = getTailAndSize(l2);

        /*
            If different tail nodes, then there's no intersection
         */
        if (result1.tail != result2.tail) {
            return null;
        }

        /*
            Set pointers to the start of each linked list
         */
        LinkedListNode shorter = result1.size < result2.size ? l1 : l2;
        LinkedListNode longer = result1.size < result2.size ? l2 : l1;

        /* Advance the pointer for the longer linked list by the difference in length */
        longer = getKthNode(longer, Math.abs(result1.size - result2.size));

        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }

        // return either one
        return longer;
    }


    class Result {
        public LinkedListNode tail;
        public int size;

        public Result(LinkedListNode tail, int size) {
            this.tail = tail;
            this.size = size;
        }
    }

    private Result getTailAndSize(LinkedListNode list) {
        if (list == null) return null;

        int size = 1;
        LinkedListNode current = list;
        while (current.next != null) {
            size++;
            current = current.next;
        }
        return new Result(current, size);
    }

    LinkedListNode getKthNode(LinkedListNode head, int k) {
        LinkedListNode current = head;
        while (k > 0 && current != null) {
            current = current.next;
            k--;
        }
        return current;
    }


    /*
        using two pointer one fast one slow.
        fast going 2x and slow going 1x speed.

        when slow pointer is at the start of the loop, say k steps , fast is already k steps in the loop since it's 2x slow speed.
        slow and fast is k steps away or (loop size - k) steps away depend which direction.

        they will meet at loop size - k turns. since fast pointer moves two nodes for each node slow pointer moves, they move
        closer to each other pointer on each turn.

        after slow and fast pointer meets. it's a loop if they are both not null.
        starting there, kept one of those pointer and change one to start of the linked list to find start of loop.

        where they met is at (loop size - k) and start of loop is k away from start of linked list.
        move they both at same speed, then they will meet each other and that's the start of loop.
     */
    public LinkedListNode loopDetection(LinkedListNode head) {

        LinkedListNode slow = head;
        LinkedListNode fast = head;

        // find where they meet.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {  // slow pointer meets fast at loop size - k.
                break;
            }
        }

        // error check - no meet point and there for no loop
        if (fast == null || fast.next == null) {
            return null;
        }

        // find start of the loop
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // either one is at start of loop
        return fast;
    }
}
