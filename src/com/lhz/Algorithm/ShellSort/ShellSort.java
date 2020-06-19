package com.lhz.Algorithm.ShellSort;

/**
 * @author lhz
 * @version 1.0
 * @date 2020/6/18 19:49
 * 希尔排序，（对插入排序的改进）
 */
public class ShellSort {
    public static void main(String[] args) {

    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        //给数组分组
        int num = arr.length / 2;
        while (num >= 1) {
            //分层num组数据，进行比较
            for (int i = 0; i < num; i++) {
                for (int j = i + num; j < n; j += num) {
                    Comparable e = arr[j];
                    int k = j;
                    for(;k>=num;k--){

                    }
                }
            }
        }
    }

}
