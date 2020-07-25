package com.lhz.Algorithm.Sort.HeapSort;

import com.lhz.Algorithm.SortTestHelper;

/**
 * @author lhz
 * @version 1.0
 * @date 2020/7/23 10:46
 */
public class MaxHeap01 {
    public int[] data;
    public int capacity;
    public int count;

    public MaxHeap01(int capacity) {
        data = new int[capacity + 1];
        this.capacity = capacity;
        count = 0;
    }

    //初始化一个最大堆
    public MaxHeap01(int[] arr, int n) {
        data = new int[n + 1];
        capacity = n;
        for (int i = 0; i < n; i++) {
            data[i + 1] = arr[i];
        }
        count = n;

        //从每一个非叶子节点ShiftDown
        for(int i=count/2;i>=1;i--){
            shiftDown(i);
        }

    }

    //数组大小
    public int size() {
        return count;
    }

    //数组是否为空
    public boolean isEmpty() {
        return count == 0;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //往堆中插入数据
    public void insert(int k) {
        assert count + 1 < capacity;
        data[count + 1] = k;
        count++;
        shiftUp(count);
    }

    //辅助函数，堆排序
    public void shiftUp(int k) {
        while (k > 1 && data[k / 2] < data[k]) {
            swap(data, k / 2, k);
            k /= 2;
        }
    }

    //取出堆顶元素并排序
    public int extractMax() {
        assert count > 0;
        int res = data[1];
        data[1] = data[count];
        shiftDown(1);
        count--;
        return res;
    }

    public void shiftDown(int k) {
        while (2 * k < count) {
            int j = 2 * k;
            if (j + 1 < count && data[j + 1] > data[j]) {
                j = 2 * k + 1;
            }
            if (data[k] > data[j]) {
                break;
            }
            swap(data, k, j);
            k = j;
        }
    }

    public void printArr(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(data[i] + " ");
        }
    }

    public static void sort(int[] arr, int n) {
        //生成一个空堆
        MaxHeap01 maxHeap01 = new MaxHeap01(n);
        for (int i = 0; i < n; i++) {
            maxHeap01.insert(arr[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            arr[i] = maxHeap01.extractMax();
        }
    }

    public static void sort02(int[] arr, int n) {
        //生成一个空堆
        MaxHeap01 maxHeap01 = new MaxHeap01(arr,n);
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = maxHeap01.extractMax();
        }
    }

    public static void main(String[] args) {
        int[] arr = SortTestHelper.generateRandomArray02(10, 1, 100);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        sort02(arr, arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
