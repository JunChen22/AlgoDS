package com.jchen.project.sorts;

/*Merge Sort


    example
    90 75 18 68 95
1st:
2nd:
3rd:
4th:
5th:

Best case:O(nLogn)
Worst case:O(nLogn)
Average case:O(nLogn)
Paradigm: Divide and Conquer
Stable: Yes
In-place: No  O(n)

*/
public class MergeSort {

    public MergeSort() {
    }

    //recursive
    public void sort(int[] arr, int left, int right) {

        //divide and conquer
        //
        //
        //divide the arr to half
        //divide first half till it's only
        if (left < right) {

            int mid = (left + right) / 2;

            //get left half
            sort(arr, left, mid);

            //get right half
            sort(arr, mid + 1, right);

            //combine the two half
            merge(arr, left, mid, right);
        }

    }

    public void merge(int[] arr, int left, int mid, int right) {

        //iterate through both
        //till one ended
        int lenLeft = mid - left + 1;
        int lenRight = right - mid;

        int[] leftArr = new int[lenLeft];
        int[] rightArr = new int[lenRight];

        for (int i = 0; i < lenLeft; i++) leftArr[i] = arr[left + i];
        for (int i = 0; i < lenRight; i++) rightArr[i] = arr[mid + i + 1];

        int i = 0, j = 0;

        int k = left;
        while (i < lenLeft && j < lenRight) {
            if(leftArr[i]<= rightArr[j]){
                arr[k] = leftArr[i];
                i++;
            }else{
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        //then append the not finish iterated
        //to the finished one

        while (i < lenLeft)
        {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < lenRight)
        {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }


    //iterative
    public void sort(int[] arr) {

    }

}
