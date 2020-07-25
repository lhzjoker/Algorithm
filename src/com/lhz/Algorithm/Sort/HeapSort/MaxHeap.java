package com.lhz.Algorithm.Sort.HeapSort;

/**
 * @author lhz
 * @version 1.0
 * @date 2020/6/22 11:55
 * 堆排序
 */

import java.lang.*;

// 在堆的有关操作中，需要比较堆中元素的大小，所以Item需要extends Comparable
public class MaxHeap<Item extends Comparable> {

    protected Item[] data;
    protected int count;
    protected int capacity;

    // 构造函数, 构造一个空堆, 可容纳capacity个元素
    public MaxHeap(int capacity) {
        data = (Item[]) new Comparable[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    // 返回堆中的元素个数
    public int size() {
        return count;
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty() {
        return count == 0;
    }

    // 像最大堆中插入一个新的元素 item
    public void insert(Item item) {

        assert count + 1 <= capacity;
        data[count + 1] = item;
        count++;
        shiftUp(count);
    }

    //最大堆中取出最大值
    public Item extractMax() {
        assert count > 0;
        Item ret = data[1];
        data[1] = data[count];
        count--;
        shiftDown(1);
        return ret;
    }


    // 交换堆中索引为i和j的两个元素
    private void swap(int i, int j) {
        Item t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    //打印值
    private void printArr(int k) {
        for (int i = 1; i <= k; i++) {
            System.out.print(data[i] + " ");
        }
    }

    //********************
    //* 最大堆核心辅助函数
    //********************
    private void shiftUp(int k) {

        while (k > 1 && data[k / 2].compareTo(data[k]) < 0) {
            swap(k, k / 2);
            k /= 2;
        }
    }

    private void shiftDown(int k) {
        //判断是否有孩子，只需判断是否有左孩子即可
        while (2 * k <= count) {
            //循环中data[k]和data[j]交换值
            int j = 2 * k;
            if (j + 1 <= count && data[j + 1].compareTo(data[j]) > 0) {
                j += 1;
            }

            if (data[k].compareTo(data[j]) > 0) {
                break;
            }

            swap(k, j);
            k = j;
        }
    }

    public static void sort(Comparable[] arr){
        //生成一个空堆
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
        Integer n = arr.length;
        for(int i=0;i<n;i++){
            maxHeap.insert((Integer) arr[i]);
        }

        for(int i=n-1;i>=0;i--){
            arr[i] = maxHeap.extractMax();
        }
    }

    // 测试 MaxHeap
    public static void main(String[] args) {

        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
        int N = 5; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0, M)
        for (int i = 0; i < N; i++) {
            maxHeap.insert(new Integer((int) (Math.random() * M)));
        }
        maxHeap.printArr(N);
        System.out.println();
        //测试取出最大值,实现从大到小打的堆排序
        while (!maxHeap.isEmpty()) {
            Integer value = maxHeap.extractMax();
            System.out.print(value + " ");
        }
//        Item[] arr=(Item[]) new Comparable[5];
//        for (int i = N - 1; i >= 0; i--) {
//            arr[i] = maxHeap.extractMax();
//        }
//        for (int i = 0; i < N; i++) {
//            System.out.print(arr[i] + " ");
//        }
    }
}
