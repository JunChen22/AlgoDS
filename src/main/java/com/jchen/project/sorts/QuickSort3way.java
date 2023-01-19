package com.jchen.project.sorts;

import java.util.Random;

/*
wasn't there a partition method?



Divide and conquer

Best: O(n) [three-way partition and equal keys]
Worst : O(n^2)
Average : O(n*logn n)

Stable: no
In-place: Yes

3-way quick sort,

 */
public class QuickSort3way<T extends Comparable<T>> {

    public static enum PIVOT_TYPE {
        FIRST, MIDDLE, RANDOM
    }

    private static final Random RAND = new Random();

    public static PIVOT_TYPE type = PIVOT_TYPE.RANDOM;

    public QuickSort3way() {
    }

    public static <T extends Comparable<T>> T[] sort(T[] unsorted) {
        return unsorted;
    }

    private static <T extends Comparable<T>> void sort (int index, int start, int end, T[] unsorted) {

    }

    private static final int getRandom(int length) {
        if (type == PIVOT_TYPE.RANDOM && length > 0) return RAND.nextInt(length);
        if (type == PIVOT_TYPE.FIRST && length > 0) return 0;
        return length/2;
    }

    private static <T extends Comparable<T>> void swap(int index1, int index2, T[] unsorted) {
        T index2Element = unsorted[index1];
        unsorted[index1] = unsorted[index2];
        unsorted[index2] = index2Element;
    }
}
