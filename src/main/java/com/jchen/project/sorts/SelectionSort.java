package com.jchen.project.sorts;

/*Selection sort
The selection sort algorithm sorts an array by repeatedly finding the
minimum element (considering ascending order) from unsorted part and putting
it at the beginning. The algorithm maintains two subarrays in a given array.

1) The subarray which is already sorted.
2) Remaining subarray which is unsorted.

In every iteration of selection sort, the minimum element
(considering ascending order) from the unsorted subarray
is picked and moved to the sorted subarray.

(https://www.geeksforgeeks.org/selection-sort/)

    example
    2 1 5 4 3
1st:1 2 5 4 3
2nd:1 2 5 4 3
3rd:1 2 3 5 4
4th:1 2 3 4 5

Best case:O(n^2)
Worst case:O(n^2)
Average case:O(n^2)

Stable: No
In-place: Yes O(1)
*/
public class SelectionSort {
    public SelectionSort() {
    }

    public int[] sort(int[] arr) {

        //the sorted section
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            //find the smallest
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) min = j;
            }
            if (i != min) {
                swap(arr, i, min);
            }
        }
        return arr;
    }

    //swap
    public void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
