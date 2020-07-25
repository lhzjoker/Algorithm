package com.lhz.Algorithm.Sort.QuickSort;

import com.lhz.Algorithm.SortTestHelper;

/**
 * @author lhz
 * @version 1.0
 * @date 2020/6/19 23:52
 * 快速排序，此方法有缺陷
 */
public class QuickSort {
    public static void main(String[] args) {
        Integer[] arr = SortTestHelper.generateRandomArray(1000000, 1, 10000000);
        SortTestHelper.testSort("com.lhz.Algorithm.Sort.QuickSort.QuickSort",arr);
//        sort(arr);
//        SortTestHelper.printArr(arr);
    }

    public static void sort(Comparable[] arr) {
        int l = 0, r = arr.length - 1;
        sort(arr, l, r);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);

    }

    public static int partition(Comparable[] arr, int l, int r) {
        Comparable temp = arr[l];
        while (l < r) {

            while (l < r && temp.compareTo(arr[r]) <= 0) {
                r--;
            }

            if (l < r) {
                arr[l] = arr[r];
                l++;
            }

            while (l < r && temp.compareTo(arr[l]) >= 0) {
                l++;
            }

            if (l < r) {
                arr[r] = arr[l];
                r--;
            }
        }
        //把基准数据赋给正确位置
        arr[l] = temp;
        //返回中间数
        return l;
    }
}