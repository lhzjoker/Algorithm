package com.lhz.Algorithm.Sort.InsertionSort;

import com.lhz.Algorithm.SortTestHelper;

/**
 * @author lhz
 * @version 1.0
 * @date 2020/6/17 23:36
 * 插入排序
 * 在近乎有序的情况下选择插入排序是效果最好的
 */
public class InsertionSort {
    public static void main(String[] args) {
        Integer[] arr = SortTestHelper.generateRandomArray(10, 1, 100);
//        SortTestHelper.testSort("com.lhz.Algorithm.Sort.InsertionSort.InsertionSort",arr);
        sort(arr);
        SortTestHelper.printArr(arr);
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;

        //插入排序方法1
        //此法有缺点，虽然说可以提前终止循环，理论上来说应该比选择排序要快，实际上却慢一些，那是因为每一次循环都要进行一次交换操作
//        for (int i = 1; i < n; i++) {
//            for (int j = i; j > 0; j--) {
//                if (arr[j-1].compareTo(arr[j]) > 0) {
//                    SortTestHelper.swap(arr, j, j - 1);
//                } else {
//                    break;
//                }
//            }
//        }

        //改进版，就不用频繁的交换了
        for (int i = 1; i < n; i++) {
            Comparable e = arr[i];
            int j = i;
            for (; j > 0 && arr[j - 1].compareTo(e) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }

    //供归并排序数量过小的时候使用的插入排序算法,对arr[l...r]的区间使用InsertionSort排序
    public static void sort(Comparable[] arr, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            Comparable e = arr[i];
            int j = i;
            for (; j > l && e.compareTo(arr[j-1])<0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }


}
