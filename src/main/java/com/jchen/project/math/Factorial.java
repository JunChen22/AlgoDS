package com.jchen.project.math;

public class Factorial {
    public Factorial() {
    }

    //recursive factorial
    public int recurFactorial(int tar) {

        if (tar == 0) return 1;
        return tar * recurFactorial(tar - 1);
    }

    //iterative factorial
    public int iterFactorial(int tar) {

        if (tar == 0) return 1;

        for (int i = tar; tar > 0; i--) {
            tar *= i;
        }

        return tar;
    }
}
