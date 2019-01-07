package com.jchen.project.sorts;

/*bubble sort
repeatedly swapping the adjacent elements if they are in wrong order.
(https://www.geeksforgeeks.org/bubble-sort/)

    example
    9 7 17 2 1
1st:7 9 2 1 17
2nd:7 2 1 9 17
3rd:2 1 7 9 17
4th:1 2 7 9 17

Best: O(n)  when array is already sorted.
Worst :O(n^2) when array is reverse sorted.
Average :O(n^2) when array is reverse sorted.

Stable: Yes
In-place: Yes O(1)
*/
public class BubbleSort {

    public BubbleSort() {
    }

    public int[] sort(int[] unsorted) {
        boolean swapped = true;
        int length = unsorted.length;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < length - 1; i++) {
                if (unsorted[i] > unsorted[i + 1]) {
                    swap(unsorted, i, i + 1);
                    swapped = true;
                }
            }
            length--;
        }
        return unsorted;
    }

    public void swap(int[] unsorted, int index1, int index2) {
        int value = unsorted[index1];
        unsorted[index1] = unsorted[index2];
        unsorted[index2] = value;
    }
}


