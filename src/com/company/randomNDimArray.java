package com.company;

import java.util.Arrays;

public class randomNDimArray {
    public static void main(String[] args) {
        //Implement the method that create an array int[n][n] of random integers
        int size0=5, size1=7;
        int[][] array2Dim = new int[size0][size1];
        array2Dim[0] = getRandomArray(size0, 0, 10);
        array2Dim[1] = getRandomArray(size1, 0, 10);
        System.out.println(Arrays.toString(array2Dim[0])+"\n"+Arrays.toString(array2Dim[1]));
    }
    public static int[] getRandomArray(int size, int min, int max) {
        int[] resArr = new int[size];

        for (int i = 0; i < size; i++) {
            resArr[i] = (int)(Math.random()*(max-min+1)+min);
        }
        return resArr;
    }

}
