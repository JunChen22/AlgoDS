package com.jchen.project.list;

import java.util.HashSet;

/*
Determining if a list is in a cycle using Floyd's Cycle Detection Algorithm.
 */
public class CycleDetection {

    public CycleDetection() {
    }

    //two pointer
    //one slow moving at 1x speed
    //one fast moving at 2x speed
    //is cycle if slow equals fast after
    // one iteration and fast done two
    public boolean isCycle(Node nd) {

        Node slow = nd;
        Node fast = nd;

        while (fast != null && fast.next != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                System.out.println("Cycle detected:" + nd.val);
                return true;
            }
        }
        return false;
    }

    public boolean isCycleWithHash(Node nd) {

        HashSet<Node> ndSet = new HashSet<>();

        while (nd != null) {
            if (ndSet.contains(nd)) {
                System.out.println("Cycle detected:" + nd.val);
                return true;
            }

            ndSet.add(nd);
            nd = nd.next;
        }
        return false;
    }
}
