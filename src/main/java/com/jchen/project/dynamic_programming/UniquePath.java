package com.jchen.project.dynamic_programming;

//4 x 3
//1 1 1 1     1 1 1 1
//1 0 0 0     1 2 3 4
//1 0 0 0     1 3 6 10

//3 x 2
//1 1 1       1 1 1
//1 0 0       1 2 3

public class UniquePath {
    public int uniquePaths(int m, int n) {
        int[][] map = new int[m][n];
        //the edges are 1
        for(int i = 0; i < m; i++) map[i][0] = 1;
        for(int j = 0; j < n; j++) map[0][j] = 1;

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                map[i][j] = map[i - 1][j] + map[i][j - 1];
            }
        }
        return map[m - 1][n - 1];
    }
}
