package com.lhz.Algorithm.QuickSort;

import com.lhz.Algorithm.InsertionSort.InsertionSort;
import com.lhz.Algorithm.SortTestHelper;

/**
 * @author lhz
 * @version 1.0
 * @date 2020/6/20 16:18
 * 针对近乎有序的数组做的优化的快速排序
 * 随机交换法：指的是选取基准点之前设计随机种子，通过随机函数得到一个在数列长度内的数，
 * 将这个随机数作为索引所指的数和第一个元素进行交换，之后将首位元素作为基准点。即随机选一个数放到首位的地方。
 * 这样一来，第一次就将最小的数交换到首位的概率是非常小的，第二次将次小的数交换到首位的概率依然非常的小。
 */
public class RandomQuickSort {
    public static void main(String[] args) {
//        Integer[] arr = SortTestHelper.generateRandomArray(1000000, 1, 10000000);
        Integer[] arr = SortTestHelper.generateNearlyOrderArray(1000000, 100);
        SortTestHelper.testSort("com.lhz.Algorithm.QuickSort.RandomQuickSort", arr);
//        sort(arr);
//        SortTestHelper.printArr(arr);
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length - 1;
        sort(arr, 0, n);
    }

    private static void sort(Comparable[] arr, int l, int r) {
//        if(l>=r){
//            return;
//        }
        //对于小数组用插入排序
        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    public static int partition(Comparable[] arr, int l, int r) {
        //取基准数据
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点
        SortTestHelper.swap( arr, l , (int)(Math.random()*(r-l+1))+l );
        Comparable e = arr[l];
        while (l < r) {

            while (l < r && e.compareTo(arr[r]) <= 0) {
                r--;
            }
            if (l < r) {
                arr[l] = arr[r];
            }
            while (l < r && e.compareTo(arr[l]) >= 0) {
                l++;
            }
            if (l < r) {
                arr[r] = arr[l];
            }
        }
        arr[l] = e;
        return l;
    }
}
