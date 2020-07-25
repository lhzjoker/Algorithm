package com.lhz.Algorithm.Sort.ShellSort;

import com.lhz.Algorithm.SortTestHelper;

import java.util.Arrays;

/**
 * @author lhz
 * @version 1.0
 * @date 2020/6/18 19:49
 * 希尔排序，（对插入排序的改进）
 */
public class ShellSort {
    public static void main(String[] args) {
        Integer[] arr = SortTestHelper.generateRandomArray(1000000, 1, 10000000);
        Integer[] arr1 = Arrays.copyOf(arr, arr.length);
//        SortTestHelper.testSort("com.lhz.Algorithm.Sort.InsertionSort.InsertionSort",arr);
        SortTestHelper.testSort("com.lhz.Algorithm.Sort.MergeSort.MergeSortAdvance",arr);
        SortTestHelper.testSort("com.lhz.Algorithm.Sort.ShellSort.ShellSort",arr1);
//        sort(arr);
//        SortTestHelper.printArr(arr);
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        //给数组分组
        int num = arr.length / 2;
        while (num >= 1) {
            //分层num组数据，进行比较（虚拟分组）
            for (int i = 0; i < num; i++) {
                //数组之间的元素相隔num个单位
                for (int j = i + num; j < n; j = j + num) {
                    Comparable e = arr[j];
                    int k = j;
                    for (; k >=num && e.compareTo(arr[k-num])<0; k = k-num) {
                        arr[k] = arr[k-num];
                    }
                    arr[k] = e;
                }
            }
            num = num/2;
        }
    }

}
