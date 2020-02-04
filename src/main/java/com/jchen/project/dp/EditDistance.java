package com.jchen.project.dp;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++)
            dp[i][0] = i;
        for (int i = 1; i <= len2; i++)
            dp[0][i] = i;
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else { // differnt
                    // dis = d(insert) + d(delete) + d(replace)
                    int replace = dp[i][j];
                    int insert = dp[i + 1][j];
                    int delete = dp[i][j + 1];
                    dp[i + 1][j + 1] = 1 + Math.min(delete, Math.min(replace, insert));
                }
            }
        }
        return dp[len1][len2];
    }
}
/*
   i n t e n t i o n
 e 1 2 3 3 4 5 6 7 8
 x 2
 e 3
 c 4
 u 5
 t 6
 i 6
 o 7
 n 8
 */
