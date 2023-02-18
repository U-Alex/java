/* 1.Реализовать алгоритм сортировки слиянием */

import java.util.Arrays;
import java.util.Random;

public class task1 {
    public static void main(String[] args) {
        int[] arr = createArray(30, 10, 100);
        System.out.println(Arrays.toString(arr));
        sort(arr, 0, arr.length - 1);
        //merge(arr, 0, 3);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] createArray(int size, int min, int max) {
        int[] arr = new int[size];
        if (min < max) {
            Random rnd = new Random();
            for (int i=0; i < size; i++) arr[i] = rnd.nextInt(min, max);
        }
        return arr;
    }

    private static void sort(int[] arr, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        //System.out.printf("sort1--%s, %s\n", start, mid);
        sort(arr, start, mid);
        //System.out.printf("sort2--%s, %s\n", mid + 1, end);
        sort(arr, mid + 1, end);
        //System.out.printf("merge--%s, %s ", start, end);
        merge(arr, start, end);
    }

    private static void merge(int[] arr, int start, int end) {
        int[] temp = new int[end - start + 1];  //4
        int mid = (start + end) / 2;            //1
        int idx1 = start;                       //0 0 0 1 2
        int idx2 = mid + 1;                     //2 3 4 4 4
        int idx3 = 0;                           //0 1 2 3 4
        while (idx1 <= mid || idx2 <= end) { 
            if (idx1 > mid) {
                temp[idx3++] = arr[idx2++];
                continue;
            }
            if (idx2 > end) {
                temp[idx3++] = arr[idx1++];
                continue;
            }
            if (arr[idx2] > arr[idx1])  temp[idx3++] = arr[idx1++]; 
            else                        temp[idx3++] = arr[idx2++];                
        }   
        for (int i = 0; i < end - start + 1; i++) arr[i + start] = temp[i];
        //System.out.println(Arrays.toString(temp));
    }
}
