package com.jchen.project.search;

/*
    finds the target in a list by searching all the elements.
 */
public class LinearSearch {

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
