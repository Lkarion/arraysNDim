package com.company;

import java.util.Arrays;

public class minSumSubarray {
    //Implement the method that finds the row’s index in the array int[n][k] of
    // random integers with minimum sum of elements
    public static void main(String[] args) {
        int size0=5, size1=7;
        int[][] array2Dim = new int[size0][size1];
        array2Dim[0] = randomNDimArray.getRandomArray(size0, 0, 10);
        array2Dim[1] = randomNDimArray.getRandomArray(size1, 0, 10);
        System.out.println(Arrays.toString(array2Dim[0])+"\n"+Arrays.toString(array2Dim[1]));

        System.out.println(getMinSumSubarray(array2Dim));
    }

    public static int getMinSumSubarray(int[][] array2Dim){
        return Math.min(getSum(array2Dim[0]), getSum(array2Dim[1]));
    }
    public static int getSum(int[] array){
        int sum = 0;
        for (int elem: array) {
            sum += elem;
        }
        return sum;
    }
}
