package com.jchen.project.CrackingCodingInterview;

import java.util.ArrayList;
import java.util.Arrays;

public class RecursionAndDP {

    /*
        O(n^3)  similar to fibonacci problem
     */
    public int tripleStep(int steps) {
        if (steps < 0) {
            return 0;
        } else if (steps == 0) {
            return 1;
        } else {
            return tripleStep(steps - 1) + tripleStep(steps - 2) + tripleStep(steps - 3);
        }
    }

    /*
        similar to the fibonacci problem but using memorization to record the solution that already solved.
        when steps is 37 it will overflow. using long will delay but not solve the issues.
     */
    public int tripleStepsMemorization(int steps) {
        int[] memorization = new int[steps + 1];
        Arrays.fill(memorization, -1);
        return countWays(steps, memorization);
    }

    private int countWays(int steps, int[] memorization) {
        if (steps < 0) {
            return 0;
        } else if (steps == 1) {
            return 1;
        } else if (memorization[steps] > -1){
            return memorization[steps];
        } else {
            memorization[steps] = countWays(steps - 1, memorization) + countWays(steps - 2, memorization) +
                    countWays(steps - 3, memorization);
        }
        return memorization[steps];
    }


    /*

     */
    public void robotInAGrid() {

    }


    public void BooleanEvaluation() {

    }
    public void Coins() {

    }
    public void EightQueens() {

    }
    public void MagicIndex() {

    }
    public void PaintFill() {

    }


    /*

     */
    public ArrayList<ArrayList<Integer>> powerSet(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allsubsets;

        if (set.size() == index) { // base case - add empty set
            allsubsets = new ArrayList<ArrayList<Integer>>();
            allsubsets.add(new ArrayList<Integer>()); // empty set
        } else {
            allsubsets= powerSet(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> subset : allsubsets) {
                ArrayList<Integer> newsubset = new ArrayList<Integer>();
                newsubset.addAll(subset);
                newsubset.add(item);
                moresubsets.add(newsubset);
            }
            allsubsets.addAll(moresubsets);
        }
        return allsubsets;
    }


    public ArrayList<ArrayList<Integer>> powerSetCombinatorics(ArrayList<Integer> set, int index) {


    }

    public void StackofBoxes() {

    }
    public void Parens() {

    }
    public void PermutationswithDuplicates() {

    }
    public void PermutationswithoutDups() {

    }
    public void RecursiveMultiply() {

    }
    public void TowersofHanoi() {

    }
}
