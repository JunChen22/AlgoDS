package com.jchen.project.sorts;

/*heap sort
It's a almost complete binary tree.At the bottom level, the leaves are on the left.
Each Node has a key associated to it.The parent node is greater than the children.
And every sub tree of the heap is also a heap.

If i is the parent then 2i+1 and 2i + 2 is the children
If j is the children then floor(j/2) is the parent


Best: O(
Worst :O(
Average :

Stable:
In-place:
*/
public class HeapSort {

    public HeapSort() {
    }

    //build a heap
    public void buildheap(int[] arr) {
        int len = arr.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    //heapify
    // idx = the root of the sub tree
    // len = heap size
    public void heapify(int[] arr, int idx, int len) {
        //idx of parent,left and right children
        int largest = idx;
        int left = (2 * idx) + 1;
        int right = (2 * idx) + 2;

        //if children is bigger than parent
        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        //check if parent is largest
        if (largest != idx) {
            //swap the parent with largest children
            int temp = arr[idx];
            arr[idx] = arr[largest];
            arr[largest] = temp;
            heapify(arr, largest, len);
        }
    }

    //sort
    public int[] sort(int[] arr) {
        buildheap(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            //i is the size , keep decreasing
            //0 is the root of the whole heap
            heapify(arr, 0, i);
        }
        return arr;
    }

    public void printHeap(int[] arr) {

        System.out.print("Sorted head:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
