package com.jchen.project.CrackingCodingInterview;

import java.util.Arrays;

public class Strings {

    /*
        128-character alphabet
        1. use the array like a set
        2. if exist return false
        3. set seen to true;

        Time: O(N) N is number of character in the string
        Space complexity: O(1) space needed is a constant
     */
    public boolean isUnique(String str) {
        if (str.length() > 128) return false;

        boolean[] char_set = new boolean[128];

        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) { // already exist
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }


    /*
        1. sort the string
        2.

        Time: (sorting time) O(nLog(n))
        Space complexity: O(N) N size of string
     */
    public boolean permutation(String s, String t) {
        if (s.length() != t.length()) return false; // should be same length
        return sort(s).equals(sort(t));
    }

    private String sort(String str) {
        char[] content = str.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }


    public boolean permutationCount(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] letters = new int[128];

        char[] s_array = s.toCharArray();

        for (char c : s_array) {
            letters[c]++;    // count the characters in string s
        }

        for (int i =0; i < t.length(); i++) {
            int c = (int) t.charAt(i);
            letters[c]--;
            if (letters[c] < 0) {
                return false;
            }
        }
        return true;
    }



    /*
        1. count the spaces
        2. replace the space with 3x
        3. reverse order to edit the string. if space replace with &20 if not copy the character over
     */
    public void URLify(char[] str, int trueLength) {
        int spaceCount = 0, index, i = 0;
        for (i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }

        index = trueLength + spaceCount * 2;   // replace a space to %20 takes 3 space
        if (trueLength < trueLength) str[trueLength] = '\0';

        for (i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' '){
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }


    /*

     */
    public boolean isPermutationOfPalindrome(String phrase) {

    }

    /*

     */
    public boolean isPermutationOfPalindrome2(String phrase) {

    }

    public boolean isPermutationOfPalindrome3(String phrase) {

    }


    /*
        edit distance/ one edit away from second string
     */
    public boolean oneAway(String str, String target) {

        if (str.length() == target.length()) {           // same length check if one edit away
            oneEditReplace(str, target);
        } else if (str.length() + 1 == target.length()) {   // check if one insert edit away
            oneEditInsert(str, target);
        } else if (str.length() == target.length() + 1) {
            oneEditInsert(target, str);
        }
        return false;
    }

    public boolean oneEditReplace(String s1, String s2) {
        return true;
    }

    public boolean oneEditInsert(String s1, String s2) {
        return true;
    }


    /*

     */
    public boolean oneEditAway(String first, String second) {
        return true;
    }



    public String compress(String str) {
        return "";
    }


    public boolean rotate(int[][] matrix) {
        return true;
    }


    public void zeroMatrix(int[][] matrix) {

    }


    /*

     */
    public boolean isRotation(String s1, String s2) {
        return true;
    }
}
