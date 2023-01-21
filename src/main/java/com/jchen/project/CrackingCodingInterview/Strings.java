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
        2. size should be the same and same letters.

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
        check if a string is a permutation of a palindrome word.
        check if a word can be palindrome.

        1. get the character counts
        2. mark if odd count exist
        3. return of the odd count if more than one.

        palindrome - all even number of character except for at most 1 in the middle

        O(N) N is the length of the phrase/string
     */
    public boolean isPermutationOfPalindrome(String phrase) {
        int countOdd = 0;

        int[] table = new int[Character.getNumericValue('z') -
                              Character.getNumericValue('a') + 1];

        for (char c: phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
                if (table[x] % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--; // will even out when it reaches second character.
                }
            }
        }
        return countOdd <= 1;
    }

    private int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }


    /*
        edit distance/ one edit away from second string
     */
    public boolean oneAway(String str, String target) {

        if (str.length() == target.length()) {           // same length check if one edit away
            oneEditReplace(str, target);
        } else if (str.length() + 1 == target.length()) {   // check if one insert edit away
            oneEditInsert(str, target);
        } else if (str.length() == target.length() + 1) {   // check if one insert edit away
            oneEditInsert(target, str);
        }
        return false;
    }

    public boolean oneEditReplace(String s1, String s2) {
        boolean foundDifference = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }

    // check if you can insert a character into s1 to make s2.
    public boolean oneEditInsert(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++; // increase in index 2 because it's a longer string
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }


    // more optimized version of oneAway
    boolean oneEditAway(String first, String second) {
        // length difference max 1.
        if (Math.abs(first.length() - second.length()) > 1) return false;

        String s1 = first.length() < second.length() ? first : second; // shorter string
        String s2 = first.length() < second.length() ? second : first; // longer string

        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;

        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (foundDifference) return false;  // more than one difference
                foundDifference = true;

                if (s1.length() == s2.length()) index1++;    // on replace, move the shorter pointer
                index2++;     // move index2 because it's longer(insert)
            } else {            // same character
                index1++;
                index2++;
            }
        }
        return true;
    }


    /*
        this will take O(p + k^2) time. p being size of the string and k^2 is concatenation time.
        It can be a bit surprising, but this code actually runs in O(N2) time.
        The reason is that in Java strings are immutable, and as a result, each time you append to the string new string object is created.
        The loop in the code does 1 + 2 + 3 + ... + N = N * (N + 1) / 2 = O(N2) operations.
        https://interviews.school/strings

        use string builder to avoid this.
     */
    public String stringCompressBad(String str) {
        String compressedString = "";
        int countConsecutive = 0;

        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {  // the order matters to not be out of bound
                compressedString += "" + str.charAt(i) + countConsecutive; // add int to string
                countConsecutive = 0;
            }
        }
        return compressedString.length() < str.length() ? compressedString : str;
    }

    public String stringCompressStringBuilder(String str) {
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)){
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.length() < str.length() ? compressed.toString() : str;
    }


    /*
        this approach is more optimal in when we don't ave a large number of repeating characters.
        Avoid us having to create string we never use.
        Downside is that it will cause a second loop through the characters.

        Benefit is memory size is limited. StringBuild size is set and without it, it will double when capacity is met.
     */
    public String stringCompress(String str) {
        int finalLength = countCompression(str);
        if (finalLength >= str.length()) return str;

        StringBuilder compressed = new StringBuilder(finalLength);
        int countConsecutive = 0;

        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.toString();
    }

    private int countCompression(String str) {
        int compressLength = 0;
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressLength += 1 + String.valueOf(countConsecutive).length();
                countConsecutive = 0;
            }
        }
        return compressLength;
    }



    /*

     */
    public boolean rotateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) return false;
        int n = matrix.length;

        for (int layer = 0; layer < n / 2; layer++) {  // going diagnal so it's half
            int first = layer;
            int last = n - 1 - layer; //  subtract the layers so it ends sooner
            for (int i = first; i < last; i++) {
                int offset = i - first;


                int top = matrix[first][i]; // temp

                // left to top
                matrix[first][i] = matrix[last - offset][first];

                // bottom to left
                matrix[last - offset][first] = matrix[last][last - offset];

                // right to bottom
                matrix[last][last - offset] = matrix[i][last];

                // top to right
                matrix[i][last] = top;
            }
        }
        return true;
    }


    /*

     */
    public void zeroMatrix(int[][] matrix) {

    }


    /*
        if a string is rotated of another string. string s1 split at x and y then yx is string s2.
        so  two s1 is xyxy and s2 is substring of xyxy.
     */
    public boolean isRotation(String s1, String s2) {
        int len = s1.length();
        if (len == s2.length() && len > 0) {
            String s1s1 = s1 + s1;
            return isSubString(s1s1, s2);
        }
        return false;
    }

    private boolean isSubString(String s1, String s2) {
        return true;
    }
}
