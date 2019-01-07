package com.jchen.project.list;

import org.junit.Test;

public class ListTest {

    @Test
    public void SinglyLinkedListTest(){
        SinglyLinkedList<Integer> SL = new SinglyLinkedList<>();


        System.out.println(SL.size());
        SL.add(24);

        SL.add(30);
        System.out.println(SL.size() +
                " head val is " + SL.getFront().val
        + " last is "+ SL.getLast().val);


        SL.add(58);
        System.out.println(SL.size() +
                " head val is " + SL.getFront().val
                + " last is "+ SL.getLast().val);
    }
}
