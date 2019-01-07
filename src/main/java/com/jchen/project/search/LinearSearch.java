package com.jchen.project.search;

public class LinearSearch {


    public LinearSearch() {
    }

    //if found return idx
    //if not found return -1
    public int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
