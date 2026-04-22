package com.day10.sort;

public class MergeSort {

    public static void main(String[] args) {

        int[] arr = {1,3,5,2,4,6};
        mergeSort(arr);
        printArray(arr);
    }

    public static void mergeSort(int[] arr) {
    	int n = arr.length;
        int i = n/2 - 1;   
        int j = n - 1;  

        int[] temp = new int[n];

        for (int k = 0; k < n; k++) {
            if (i >= 0 && j >= n/2) {
                if (arr[i] >= arr[j]) {
                    temp[k] = arr[i--];
                } else {
                    temp[k] = arr[j--];
                }
            } else if (i >= 0) {
                temp[k] = arr[i--];
            } else {
                temp[k] = arr[j--];
            }
        }

        for (int k = 0; k < n; k++) {
            arr[k] = temp[k];
        }
    }

    public static void printArray(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            System.out.print(arr[i] + " ");
            i++;
        }
    }
}
