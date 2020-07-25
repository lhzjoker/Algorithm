package com.lhz.Algorithm.Sort.MergeSort;

import com.lhz.Algorithm.Sort.InsertionSort.InsertionSort;
import com.lhz.Algorithm.SortTestHelper;

import java.util.Arrays;

/**
 * @author lhz
 * @version 1.0
 * @date 2020/6/19 12:28
 * 归并排序优化
 */
public class MergeSortAdvance {
    public static void main(String[] args) {
        int N = 10;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 1, 100);
        sort(arr);
        SortTestHelper.printArr(arr);
        //测试改进算法的性能
//                Integer[] arr1 = Arrays.copyOf(arr, arr.length);
//        SortTestHelper.testSort("com.lhz.Algorithm.Sort.MergeSort.MergeSort",arr);
//        SortTestHelper.testSort("com.lhz.Algorithm.Sort.MergeSort.MergeSortAdvance",arr1);
    }

    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        //当数量较小的时候使用插入排序
        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }

        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        //改进，当左边的数还有大于右数的时候进行排序，否则就不用考虑,当数组近乎有序的时候可以加上，不然不用，判断也会耗费时间
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r);
        }
    }

    public static void merge(Comparable[] arr, int l, int mid, int r) {
        //复制数组
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);
        //左右半部分的起使位置
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {  //左半部分数组排序完成
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {  //右半部分数组排序完成
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) < 0) {
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }
    }
}
