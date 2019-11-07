package Algoritms.Sorts;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1,5,6,2,4,9,1,2,5,9,6,5,1,2,4,5,9,1,9,5,8,3};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr, int left, int right) {
        if (arr.length == 0) return;
        if(left >= right) return;

        int middle = (left + right ) / 2;
        int pivot = arr[middle];

        int i = left, j = right;
        while (i < j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
             }
        }
        if( left < j) quickSort(arr, left, j);
        if( right > i) quickSort(arr, i, right);
    }
}
