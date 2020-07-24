package com.lhz.Algorithm.QuickSort;

import com.lhz.Algorithm.InsertionSort.InsertionSort;
import com.lhz.Algorithm.SortTestHelper;

import java.util.Arrays;

/**
 * @author lhz
 * @version 1.0
 * @date 2020/6/21 13:11
 * 三路快速排序
 * 也是处理含有大量重复数据的数组，只不过与双路不同的是，它分成了三块，>e,=e,<e
 */
public class ThreeWayQuickSort {
    public static void main(String[] args) {
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 1, 10);
        Integer[] arr1 = Arrays.copyOf(arr, arr.length);
        SortTestHelper.testSort("com.lhz.Algorithm.QuickSort.TwoWayQuickSort",arr);
        SortTestHelper.testSort("com.lhz.Algorithm.QuickSort.ThreeWayQuickSort",arr1);
//        Integer[] arr = SortTestHelper.generateRandomArray(30, 1, 100);
//        sort(arr);
//        SortTestHelper.printArr(arr);
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length - 1;
        sort(arr, 0, n);
    }

    private static void sort(Comparable[] arr, int l, int r) {
//        if (r - l <= 15) {
//            InsertionSort.sort(arr, l, r);
//            return;
//        }

        SortTestHelper.swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);
        Comparable e = arr[l];
        //arr[l+1...lt] < v  arr[gt...r] > v  arr[lt+1...i) == v
        int i = l + 1, lt = l, gt = r + 1;
        while (i < gt) {
            if (e.compareTo(arr[i]) > 0) {
                SortTestHelper.swap(arr,i,lt+1);
                lt++;
                i++;
            } else if (e.compareTo(arr[i]) < 0) {
                SortTestHelper.swap(arr, i, gt - 1);
                gt--;
            } else {
                i++;
            }
        }
        SortTestHelper.swap(arr, l, lt);
        sort(arr, l, lt - 1);
        sort(arr, gt, r);
    }
}
