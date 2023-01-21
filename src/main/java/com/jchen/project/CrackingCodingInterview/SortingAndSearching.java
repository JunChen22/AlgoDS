package com.jchen.project.CrackingCodingInterview;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SortingAndSearching {

    /*
        insertion sort but start insert in end of array A.
        1. get last indexes of the arrays
        2. merge them, compare them and put it at the end first.
        3. until array is all done

        Time: O(N)
        Space : no additional space needed.
     */
    public void sortedMerge(int[] a, int[] b, int lastA, int lastB) {
        int indexA = lastA - 1;
        int indexB = lastB -1;
        int indexMerged = lastB + lastA + 1;

        while (indexB >= 0) {
            if (indexA >= 0 && a[indexA] > b[indexB]) {
                a[indexMerged] = a[indexA];
                indexA--;
            } else {
                a[indexMerged] = b[indexB];
                indexB--;
            }
            indexMerged--;
        }
    }

    /*
        A modification to bucket sort
        Anagram - same characters but different orders

        1. the anagram is the same when they are sorted.
        2. put it in a hashmap with sorted anagram as key
        3. covert the hashmap back into array.

     */
    public void groupAnagrams(String[] array) {
        HashMap<String, List<String>> mapList = new HashMap<String, List<String>>();
        List<String> arrList = new ArrayList<>();

        // put the anagram in map
        for (String str : array) {
            String key = sortChars(str);
            if (mapList.containsKey(key)) {
                arrList = mapList.get(key);
            }
            arrList.add(str);
            mapList.put(key, arrList);
            arrList.clear();
        }

        // convert hash map back into array
        int index = 0;
        for (String key : mapList.keySet()) {
            List<String> strList = mapList.get(key);
            for (String t : strList) {
                array[index] = t;
                index++;
            }
        }
    }

    private String sortChars(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }


    /*


        E.g
        array1 = {10, 15, 20, 0, 5}
        mid = 20
        x = 5  // find 5

       left = 10 right = 5
       left side is normally ordered
       x is not bigger than left or mid going call right side
       searchInRotatedArray(a, mid + 1, right, x)

       left = 0  right = 5
       mid = 0
       a[left] == a[mid]
       right is different
       call searchInRotatedArray(a, mid + 1, right, x)

       mid and right is the same,5
       x == a[mid]
       return mid;

        time: O(Log n) if all element is unique. O(n) if there are many duplicate
     */
    public int searchInRotatedArray(int a[], int left, int right, int x) {
        int mid = (left + right) / 2;
        if (x == a[mid]) {
            return mid;
        }

        if (right < left) {
            return -1;
        }

        /*
            Either the left or right half must be normally ordered.
            Find out which side is normally ordered, and then use the normally ordered half to figure out
            which side to search to find x. */
        if (a[left] < a[mid]) { // left is normally ordered
            if (x >= a[left] && x < a[mid]) {
                return searchInRotatedArray(a, left, mid - 1, x);
            } else {
                return searchInRotatedArray(a, mid + 1, right, x);
            }
        } else if (a[mid] < a[left]) { // right is normally ordered
            if (x > a[mid] && x <= a[right]) {
                return searchInRotatedArray(a, mid + 1, right, x);
            } else {
                return searchInRotatedArray(a, left, mid - 1, x);
            }
        } else if (a[left] == a[mid]) { // either left or right half is all repeats
            if (a[mid] != a[right]) { // if right is different, search it
                return searchInRotatedArray(a, mid + 1, right, x);
            } else {
                int result = searchInRotatedArray(a, left, mid - 1, x);
                if (result == -1) {
                    return searchInRotatedArray(a, mid + 1, right, x);
                } else {
                    return result;
                }
            }
        }
        return -1;
    }




    public static class Listy {

    }
    /*

     */
    public int sortedSearchNoSize(Listy list, int value) {
        return -1;
    }

    private int binarySearch(Listy list, int target, int low, int high) {
        return -1;
    }





    /*

     */
    public int sparseSearch(String[] strings, String str) {
        if (strings == null || str == null || str == "") {
            return -1;
        }
        return sparseSearch(strings, str, 0, strings.length - 1);
    }

    private int sparseSearch(String[] strings, String str, int first, int last) {
        if (first > last) return -1;

        int mid = (last + first) / 2;

        // if mid is empty, find the closest non-empty string.
        if (strings[mid].isEmpty()) {
            int left = mid - 1;
            int right = mid + 1;

            while (true) {
                if (left < first && right > last) {
                    return -1;
                } else if (right <= last && !strings[right].isEmpty()) {
                    mid = right;
                    break;
                } else if (left >= first && !strings[left].isEmpty()) {
                    mid = left;
                    break;
                }
                right++;
                left++;
            }
        }

        // check for string and recurse if necessary
        if (str.equals(strings[mid])) { // found it
            return mid;
        } else if (strings[mid].compareTo(str) < 0) { // search right
            return sparseSearch(strings, str, mid + 1, last);
        } else { // search left
            return sparseSearch(strings, str, first, mid - 1);
        }
    }


    /*

     */
    public int[][] sortedMatrixSearchNaive(int[][] matrix, int element) {
        return null;
    }

    public int[][] sortedMatrixSearchNaiveBinarySearch(int[][] matrix, int element) {
        return null;
    }


    /*

     */
    public int rankFromStream(int d) {
        return 0;
    }


    /*
        In an array of integers, a "peak" is an element which is greater than or equal to the adjacent integer and a "valley"
        is an element which is less than or equal to the adjacent integer.
        E.g.
            [5,8,6,2,3,4,6]
         so lowest point and highest point.

     */
    public void peaksAndValleys(int[] array) {

    }
}
