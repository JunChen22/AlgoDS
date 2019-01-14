//package com.jchen.project.list;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.jchen.project.list.DoublyLinkedList;
import com.jchen.project.list.SinglyLinkedList;


public class ListTest {

    private final int SIZE = 10000;
    private final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    private static char[] charArr = null;
    private static String[] strArr = null;
    private static int[] intArr = null;

    //private Node
    @Before
    public void setUp() {

        //generate a list of integers
        intArr = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            intArr[i] = i;
        }

        //generate array of char of alphabets
        charArr = ALPHABET.toCharArray();

        //generate array of string of alphabets
        strArr = new String[ALPHABET.length()];
        for (int i = 0; i < charArr.length; i++) {
            strArr[i] = charArr[i] + "";
        }
    }

    @Test
    public void SinglyLinkedListTest() {

        SinglyLinkedList<String> strList = new SinglyLinkedList<>();

        boolean status = strList.addAll(strArr.clone());
        assertTrue(status);

        // add( int idx, T value);
        strList.add(25, "middle");
        assertEquals("middle", strList.get(26));

        //addFirst(T value);
        strList.addFirst("front");
        assertEquals("front", strList.getFront());

        //addLast(T value);
        strList.addLast("last");
        assertEquals("last", strList.getLast());

        //size()
        assertEquals(strArr.length + 3, strList.size());

        //remove() , testing for non exist value
        status = strList.remove("Non-exist str");
        assertFalse(status);

        //remove()
        status = strList.remove("middle");
        assertTrue(status);

        //contains(T value);
        assertTrue(strList.contains("front"));
        assertFalse(strList.contains("middle"));

        //toString();
        strList.remove("front");
        strList.remove("last");
        String result = strList.toString();
        assertEquals(ALPHABET, result);

        //clear();
        strList.clear();
        assertEquals(0, strList.size());
        assertNull(strList.getFront());
    }
}
