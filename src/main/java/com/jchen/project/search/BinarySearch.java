package com.jchen.project.search;

public class BinarySearch {

    public BinarySearch() {
    }

    //return idx

    public int search(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            //test if found
            if (target == arr[mid]) return mid;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        //return -1 for not found
        return -1;
    }
}
