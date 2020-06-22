package com.lhz.Algorithm;


import java.util.Arrays;

/**
 * @author lhz
 * @version 1.0
 * @date 2020/6/17 12:49
 * 测试算法
 */
public class TestSort {
    public static void main(String[] args) {

        //测试选择排序和插入排序性能，一般情况下选择排序比插入要好一点，但是在近乎有序的情况下，插入排序效率是极高的
        int N = 100000;
        Integer[] arr1 = SortTestHelper.generateNearlyOrderArray(N, 1);
//        Integer [] arr1 = SortTestHelper.generateRandomArray(N,1,10);
//        //复制arr1数组
        Integer[] arr2 = Arrays.copyOf(arr1,arr1.length);
        SortTestHelper.testSort("com.lhz.Algorithm.MergeSort.MergeSortAdvance",arr1);
        SortTestHelper.testSort("com.lhz.Algorithm.QuickSort.QuickSort",arr2);
    }
}
