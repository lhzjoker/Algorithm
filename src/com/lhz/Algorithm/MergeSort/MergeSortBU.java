package com.lhz.Algorithm.MergeSort;

import com.lhz.Algorithm.InsertionSort.InsertionSort;
import com.lhz.Algorithm.SortTestHelper;

import java.util.Arrays;

/**
 * @author lhz
 * @version 1.0
 * @date 2020/6/19 15:49
 * 归并排序迭代法
 * 自底向上的迭代法
 */

// Merge Sort BU 也是一个O(nlogn)复杂度的算法，虽然只使用两重for循环
// 所以，Merge Sort BU也可以在1秒之内轻松处理100万数量级的数据
// 注意：不要轻易根据循环层数来判断算法的复杂度，Merge Sort BU就是一个反例
public class MergeSortBU {
    public static void main(String[] args) {
        Integer[] arr = SortTestHelper.generateRandomArray(1000000, 1, 10000000);
        sort(arr);
        SortTestHelper.testSort("com.lhz.Algorithm.MergeSort.MergeSortBU", arr);
//        SortTestHelper.printArr(arr);
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        //sz为元素数组的大小
        for (int sz = 1; sz < n; sz *= 2) {
            for (int i = 0; i + sz < n; i += sz + sz) {
                // 对 arr[i...i+sz-1] 和 arr[i+sz...i+2*sz-1] 进行归并
                merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
            }
        }

        //改进
        //对小数组进行插入排序
//        for (int i = 0; i < n; i += 16) {
//            InsertionSort.sort(arr, i, Math.min(i + 15, n - 1));
//        }
//
//        for (int sz = 16; sz < n; sz *= 2) {
//            for (int i = 0; i + sz < n; i += sz + sz) {
//                //只有当左边还有数大于右边时才排序，否则已经排好序了，能快蛮多
//                if (arr[i + sz - 1].compareTo(arr[i + sz]) > 0) {
//                    merge(arr, i, i + sz - 1, Math.min(i + 2 * sz - 1, n - 1));
//                }
//            }
//        }
    }

    public static void merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
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

