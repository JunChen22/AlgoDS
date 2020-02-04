package com.jchen.project.string;

public class ReverseString {

    public ReverseString() {
    }

    public String reverse(String str) {
        char[] charArr = str.toCharArray();
        int start = 0;
        int end = str.length() - 1;

        //reversing the chars
        while (start < end) {
            char temp = charArr[start];
            charArr[start] = charArr[end];
            charArr[end] = temp;
            start++;
            end--;
        }
        //return new string
        return new String(charArr);
    }
}
