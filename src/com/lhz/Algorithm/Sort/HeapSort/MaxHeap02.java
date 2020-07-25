package com.lhz.Algorithm.Sort.HeapSort;

import com.lhz.Algorithm.SortTestHelper;

/**
 * @author lhz
 * @version 1.0
 * @date 2020/7/24 17:50
 * 原地堆排序，用数组来存储一个堆，不用新建一个堆，节省了空间
 */
public class MaxHeap02 {
    public static void sort(int[] arr) {
        //heapify
        int n = arr.length;
        //因为最后一个元素是n-1,所以它的父节点为(n-1-1)/2
        for (int i = (n - 1 - 1) / 2; i >= 0; i--) {
            shiftDown02(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(arr, i, 0);
            shiftDown02(arr, i, 0);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //注意数组下标是从0开始的
    public static void shiftDown(int[] arr, int n, int k) {
        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 < n && arr[j] < arr[j + 1]) {
                j = 2 * k + 2;
            }
            if (arr[k] >= arr[j]) {
                break;
            }
            swap(arr, k, j);
            k = j;
        }
    }

    // 优化的shiftDown过程, 使用赋值的方式取代不断的swap,
    // 该优化思想和我们之前对插入排序进行优化的思路是一致的
    public static void shiftDown02(int[] arr, int n, int k) {
        int temp = arr[k];
        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 < n && arr[j + 1] > arr[j]) {
                j = j + 1;
            }
            //注意这里是temp，不是arr[k]，因为没有交换值
            if (temp >= arr[j]) {
                break;
            }
            arr[k] = arr[j];
            k = j;
        }
        arr[k] = temp;
    }


    public static void main(String[] args) {
        int[] arr = SortTestHelper.generateRandomArray02(10, 1, 100);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
