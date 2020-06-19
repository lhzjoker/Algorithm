package com.lhz.Algorithm.MergeSort;

import com.lhz.Algorithm.SortTestHelper;
import com.sun.javaws.Main;

import java.util.Arrays;

/**
 * @author lhz
 * @version 1.0
 * @date 2020/6/19 0:09
 * 归并排序，第一个学习的NlogN级别的排序算法
 */
public class MergeSort {
    public static void main(String[] args) {
        //测试百万级数量，n2的时间复杂度不要尝试，会卡死
//        Integer[] arr = SortTestHelper.generateNearlyOrderArray(1000000, 6);
                Integer[] arr = SortTestHelper.generateRandomArray(1000000, 1, 1000000);
        Integer[] arr1 = Arrays.copyOf(arr, arr.length);
//        sort(arr);
//        SortTestHelper.printArr(arr);
        SortTestHelper.testSort("com.lhz.Algorithm.MergeSort.MergeSort",arr);
        SortTestHelper.testSort("com.lhz.Algorithm.InsertionSort.InsertionSort",arr1);
    }

    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
            merge(arr, l, mid, r);
    }

    private static void merge(Comparable[] arr, int l, int mid, int r) {
        //开辟数组
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);
        //左右两边数组的起始位置
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {      //左半部分数组已经完成排序
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {     //右半部分数组已经完成排序
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) < 0) {   // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i - l];
                i++;
            } else {      // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j - l];
                j++;
            }
        }
    }
}
