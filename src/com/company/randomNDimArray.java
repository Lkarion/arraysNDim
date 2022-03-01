package com.company;

import java.util.Arrays;

public class randomNDimArray {
    public static void main(String[] args) {
        //Implement the method that create an array int[n][n] of random integers
        System.out.println(Arrays.deepToString(getRandomArray2Dim(10,0,100)));

    }
    public static int[] getRandomArray(int size, int min, int max) {
        int[] resArr = new int[size];

        for (int i = 0; i < size; i++) {
            resArr[i] = (int)(Math.random()*(max-min+1)+min);
        }
        return resArr;
    }

    public static int[][] getRandomArray2Dim (int maxLen, int min, int max){
        int[][] resArr = new int[(int)(Math.random()*maxLen)][(int)(Math.random()*maxLen)];
        for (int i = 0; i < resArr.length; i++) {
            for (int j = 0; j < resArr[i].length; j++) {
                resArr[i][j] = (int)(Math.random()*(max-min+1)+min);
            }
        }
        return resArr;
    }

}
