package com.company;

public class Main {

    public static void main(String[] args) {
        //1. массив 10*10 от 99 до 0
        int [][] array = new int[10][10];
        fillArray(array);
        System.out.println("1. массив 99-0");
        print2Array(array);

        //2. 1мер массив, все его пол элементы *3
        System.out.println("\n 2. Positive elements of array:");
        int [] array1 = new int[]{1,6,-4,-7,5};
        int[] arrayPos = getPosElements(array1);
        printArray(arrayPos);

        //3. 1мер массив, все элементы с нечетными индексами =0
        System.out.println();
        System.out.println("\n 3.");
        array1 = changeOddIndexElemenets(array1);
        printArray(array1);

        //4. 2мер массив, есть ли отриц элементы
        System.out.println("\n 4.");
        int[][] array2Dim = new int[][]{{1,24,3,5,3},{2,-3,3,4,3},{5,6,2,1,1}};
        print2Array(array2Dim);
        System.out.println("There are negative elements - "+checkIfNeg(array2Dim));

        //5. 2мер массив, возвр кол-во подмассивов, в которых есть отриц элементы
        System.out.println("\n 5. Subarrays with negative elements : "+countNegSubarrays(array2Dim));

        //6. 2мер массив, возвр кол-во подмассивов, в которых нет отриц элементов
        System.out.println("\n 6. Subarrays with no negative elements : "+countNotNegSubarrays2(array2Dim));

        //7. сложить числа в 2мер массиве только из тех подмассивов, где нет отриц элементов
        System.out.println("\n 7. Sum of elements from non negative subarrays = "+getSumNotNeg(array2Dim));

        //8. метод, возвр n-ое число Фибоначчи
        int f = 18;
        System.out.println("\n 8. Fibonacci "+f+" = "+getFibonacci(f));

        //9. Selection Sort
        System.out.println("\n 9. Selection Sort:");
        selectionSort(array1);
        printArray(array1);
    }

    public static void printArray(int[] array){
        for (int i=0; i< array.length; i++){
            System.out.print(array[i]+"\t");
        }
    }

    public static void print2Array(int[][] array){
        for (int i=0; i< array.length; i++){
            printArray(array[i]);
            System.out.println();
        }
    }

    //1. массив 10*10 от 99 до 0
    public static int[][] fillArray(int[][] array){
        int n=99;
        for (int i=0; i<10;i++){
            for (int j=0; j<10;j++){
               array[i][j]=n;
               n--;
            }
        }
        return array;
    }

    //2. 1мер массив, все его пол элементы *3
    public static int[] getPosElements(int[] array){
        int[] arrayPos = new int[array.length];
        int j=0;
        for (int i=0; i< array.length;i++){
            if (array[i]>=0){
                arrayPos[j] = array[i]*3;
                j++;
            }
        }
        return arrayPos;
    }

    //3. 1мер массив, все элементы с нечетными индексами =0
    public static int[] changeOddIndexElemenets(int[] array){
        for (int i=0; i< array.length; i++){
            if (i % 2 != 0){
                array[i] = 0;
            }
        }
        return array;
    }

    //4. 2мер массив, есть ли отриц элементы
    static boolean checkIfNeg(int[][] array2Dim){
        for (int i=0; i< array2Dim.length; i++){
            for (int j=0; j< array2Dim[i].length; j++){
                if (array2Dim[i][j] < 0) return true;
            }
        }
        return false;
    }

    //5. 2мер массив, возвр кол-во подмассивов, в которых есть отриц элементы
    static int countNegSubarrays(int[][] array2Dim){
        int num = 0;
        for (int i=0; i< array2Dim.length; i++){
            for (int j=0; j< array2Dim[i].length; j++){
                if (array2Dim[i][j] < 0) {
                    num++;
                    break;
                };
            }
        }
        return num;
    }

    //6. 2мер массив, возвр кол-во подмассивов, в которых нет отриц элементов
    static int countNotNegSubarrays(int[][] array2Dim){
        int num = 0;
        for (int i=0; i< array2Dim.length; i++){
            if(!checkIfNegArray(array2Dim[i]))
                num++;
        }
        return num;
    }

    static int countNotNegSubarrays2(int[][] array2Dim){
        int num = 0;
        outerFor:
        for (int i=0; i< array2Dim.length; i++){
            for (int j = 0; j < array2Dim[i].length; j++) {
                if (array2Dim[i][j] < 0){
                    continue outerFor;
                }
            }
            num++;
        }
        return num;
    }

    static boolean checkIfNegArray(int[] array){
        for (int i=0; i< array.length; i++){
            if (array[i] < 0){
                    return true;
            }
        }
        return false;
    }

    //7. сложить числа в 2мер массиве только из тех подмассивов, где нет отриц элементов
    static int getSumNotNeg(int[][] array2Dim){
        int sum=0;
        for (int i=0; i< array2Dim.length; i++) {
            if(!checkIfNegArray(array2Dim[i])){
                for (int j=0; j<array2Dim[i].length; j++){
                    sum+=array2Dim[i][j];
                }
            }
        }
        return sum;
    }

    //8. метод, возвр n-ое число Фибоначчи
    static int getFibonacci(int f){
        int[] arrayFib = new int[f+1];
        arrayFib[0] = 0;
        arrayFib[1] = 1;
        if (f>1){
            for (int i=2; i<arrayFib.length; i++){
                arrayFib[i] = arrayFib[i-1] + arrayFib[i-2];
            }
        }
        return arrayFib[f];
    }

    //9. Selection Sort
    static int findMin(int[] array, int indexNotSorted){
        int min = array[0];
        for (int i = indexNotSorted; i < array.length; i++) {
            if (min > array[i]){
                min = array[i];
            }
        }
        return min;
    }

    static int findMinIndex(int[] array, int indexNotSorted){
        int minIndex = indexNotSorted;
        int min = array[indexNotSorted];
        for (int i = indexNotSorted; i < array.length; i++) {
            if (min > array[i]){
                min = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    static void selectionSort(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            array[findMinIndex(array,i)] = array[i];
            array[i] = findMin(array, i);
        }
    }
}