package com.lhz.Algorithm.QuickSort;

import com.lhz.Algorithm.InsertionSort.InsertionSort;
import com.lhz.Algorithm.SortTestHelper;
import jdk.nashorn.internal.ir.WhileNode;

import java.util.Arrays;

/**
 * @author lhz
 * @version 1.0
 * @date 2020/6/21 11:41
 * 双路快速排序，可以处理大量重复数据的数组
 */
public class TwoWayQuickSort {
    public static void main(String[] args) {
        int N = 100000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 1, 10);
        Integer[] arr1 = Arrays.copyOf(arr, arr.length);
        SortTestHelper.testSort("com.lhz.Algorithm.QuickSort.TwoWayQuickSort",arr);
        SortTestHelper.testSort("com.lhz.Algorithm.QuickSort.RandomQuickSort",arr1);
//        sort(arr);
//        SortTestHelper.printArr(arr);
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length - 1;
        sort(arr,0,n);
    }

    private static void sort(Comparable[] arr, int l, int r) {

        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    private static int partition(Comparable[] arr, int l, int r) {
        SortTestHelper.swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);
        int i = l + 1, j = r;
        Comparable e = arr[l];
        while (true) {
            while (i <= r && e.compareTo(arr[i]) > 0) {
                i++;
            }
            while (j >= l + 1 && e.compareTo(arr[j]) < 0) {
                j--;
            }
            if (i > j) {
                break;
            }
            SortTestHelper.swap(arr, i, j);
            i++;
            j--;
        }
        SortTestHelper.swap(arr, l, j);
        return j;
    }
}
