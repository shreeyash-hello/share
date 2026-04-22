package com.day10.sort;

public class HeapSort {

	public static void main(String [] args) {
		int[] arr = {5, 2, 9, 1, 6, 3};
		heapSort(arr);
		printArray(arr);
	}
	
	public static void heapSort(int[] arr) {
	    int n = arr.length;
	    for (int i = n / 2 - 1; i >= 0; i--) {
	        minHeap(arr, n, i);
	    }
	    for (int i = n - 1; i >= 0; i--) {
	        int temp = arr[0];
	        arr[0] = arr[i];
	        arr[i] = temp;

	        minHeap(arr, i, 0);
	    }
	}

	public static void minHeap(int[] arr, int n, int i) {
	    int smallest = i;
	    int left = 2 * i + 1;
	    int right = 2 * i + 2;

	    if (left < n && arr[left] < arr[smallest])
	        smallest = left;

	    if (right < n && arr[right] < arr[smallest])
	        smallest = right;

	    if (smallest != i) {
	        int temp = arr[i];
	        arr[i] = arr[smallest];
	        arr[smallest] = temp;

	        minHeap(arr, n, smallest);
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
