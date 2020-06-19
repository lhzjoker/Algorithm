package com.lhz.Algorithm.BubbleSort;

import com.lhz.Algorithm.SortTestHelper;

/**
 * @author lhz
 * @version 1.0
 * @date 2020/6/18 15:33
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        Integer[] arr = SortTestHelper.generateRandomArray(10, 1, 100);
        BubbleSort.sort(arr);
        SortTestHelper.printArr(arr);
//        SortTestHelper.testSort("com.lhz.Algorithm.BubbleSort.BubbleSort",arr);
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        //冒泡排序，一个一个冒泡排上去，外层循环是需要比较的数的个数，内存循环是每个数需要比较的次数
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = 0; j < n - i - 1; j++) {
//                if (arr[j].compareTo(arr[j + 1]) > 0) {
//                    SortTestHelper.swap(arr, j, j + 1);
//                }
//            }
//        }


//        Boolean swapped = false;
//        //改进版冒泡,已经排好序就可以提前终止循环
//        do {
//            swapped = false;
//            for (int i = 1; i < n; i++) {
//                if (arr[i - 1].compareTo(arr[i]) > 0) {
//                    SortTestHelper.swap(arr, i - 1, i);
//                    swapped = true;
//                }
//            }
//
//            // 优化, 每一趟Bubble Sort都将最大的元素放在了最后的位置
//            // 所以下一次排序, 最后的元素可以不再考虑
//            n--;
//        } while (swapped);


        int newn; // 使用newn进行优化
        do{
            newn = 0;
            for( int i = 1 ; i < n ; i ++ ) {
                if( arr[i-1].compareTo(arr[i]) > 0 ){
                    SortTestHelper.swap( arr , i-1 , i );

                    // 记录最后一次的交换位置,在此之后的元素在下一轮扫描中均不考虑
                    newn = i;
                }
            }
            n = newn;
        }while(newn > 0);
    }


}
