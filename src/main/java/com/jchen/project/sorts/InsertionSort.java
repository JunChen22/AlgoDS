package com.jchen.project.sorts;

/*Insertion Sort
consuming one input element each repetition, and growing a sorted
output list. At each iteration, insertion sort removes one element from the
input data, finds the location it belongs within the sorted list, and
inserts it there. It repeats until no input elements remain.
(https://en.wikipedia.org/wiki/Insertion_sort)

    example
    90 75 18 68 95
1st:90 75 18 68 95
2nd:75 90 18 68 95
3rd:18 75 90 68 95
4th:18 68 75 90 95
5th:18 68 75 90 95

Best case:O(n) almost sorted
Worst case:O(n^2) when reverse sorted
Average case:O(n^2)

Stable: Yes
In-place: Yes O(1)

better than bubble sort because there's no full pass and use when data is small
*/

public class InsertionSort {

    public InsertionSort() {
    }

    public int[] sort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            int key = arr[i];
            int j = i - 1 ;

            //find the spot to switch
            //from right to left,
            // greater than 0 , and
            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        return arr;
    }

}
