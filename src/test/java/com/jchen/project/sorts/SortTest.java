package com.jchen.project.sorts;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class SortTest {

    private static final int SIZE = 10000;
    private static final Random RANDOM = new Random();

    private static int[] sorted;
    private static int[] unsorted;
    private static int[] reversed;

    @Before
    public void setUp() {
        //generate sorted array
        sorted = new int[SIZE];
        for (int i = 0; i < sorted.length; i++) {
            sorted[i] = i;
        }

        //generate random unsorted array
        unsorted = new int[SIZE];
        for (int i = 0; i < unsorted.length; i++) {
            unsorted[i] = sorted[RANDOM.nextInt(SIZE)];
        }

        //reversed the unsorted array
        reversed = new int[SIZE];
        for (int i = (reversed.length - 1); i >= 0; i--) {
            reversed[i] = (SIZE - 1) - i;
        }
    }

    @Test
    public void BubbleSortTest() {
        BubbleSort bs = new BubbleSort();
        int[] result = bs.sort(sorted.clone());
        assertTrue(check(result));

        result = bs.sort(unsorted.clone());
        assertTrue(check(result));

        result = bs.sort(reversed.clone());
        assertTrue(check(result));
    }

    @Test
    public void InsertionSortTest() {

        InsertionSort is = new InsertionSort();
        int[] result = is.sort(sorted.clone());
        assertTrue(check(result));

        result = is.sort(unsorted.clone());
        assertTrue(check(result));

        result = is.sort(reversed.clone());
        assertTrue(check(result));
    }

    @Test
    public void SelectionSortTest() {

        SelectionSort ss = new SelectionSort();
        int[] result = ss.sort(sorted.clone());
        assertTrue(check(result));

        result = ss.sort(unsorted.clone());
        assertTrue(check(result));

        result = ss.sort(reversed.clone());
        assertTrue(check(result));
    }

    @Test
    public void QuickSortTest() {
        /*
        QuickSort qs = new QuickSort();
        int[] result = qs.sort(sorted.clone());
        assertTrue(check(result));

        result = qs.sort(unsorted.clone());
        assertTrue(check(result));

        result = qs.sort(reversed.clone());
        assertTrue(check(result));
        */
    }


    @Test
    public void RadixSortTest() {
    }

    @Test
    public void MergeSortTest() {

        MergeSort ms = new MergeSort();

        //recursive merge sort
        int[] arr  = sorted.clone();
        ms.sort(arr,0,arr.length-1);
        assertTrue(check(arr));

        arr  = unsorted.clone();
        ms.sort(arr,0,arr.length-1);
        assertTrue(check(arr));

        arr = reversed.clone();
        ms.sort(arr,0,arr.length-1);
        assertTrue(check(arr));


        /*
        //iterative merge sort
        arr = ms.sort(sorted.clone());
        assertTrue(check(arr));

        arr = ms.sort(unsorted.clone());
        assertTrue(check(arr));

        arr = ms.sort(reversed.clone());
        assertTrue(check(arr));
        */
    }

    public boolean check(int[] arr){
        for(int i = 0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                System.out.println(arr[i]+" " + arr[i+1]);
                return false;
            }
        }
        return  true;
    }

}
