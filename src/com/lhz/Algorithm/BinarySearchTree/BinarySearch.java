package com.lhz.Algorithm.BinarySearchTree;

/**
 * @author lhz
 * @version 1.0
 * @date 2020/7/25 12:55
 * 二分查找法，必须是有序数组
 */
public class BinarySearch {
    //递归二分查找法
    public int search01(int[] arr, int l, int r, int k) {
        if (l > r) {
            return -1;
        }
        //int mid = (l+r)/2;
        // 防止极端情况下的整形溢出，使用下面的逻辑求出mid
        int mid = l + (r - l) / 2;
        if (arr[mid] == k) {
            return mid;
        } else if (arr[mid] > k) {
            return search01(arr, l, mid - 1, k);
        } else {
            return search01(arr, mid + 1, r, k);
        }
    }

    public int search02(int[] arr, int k) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            //int mid = (l + r)/2;
            // 防止极端情况下的整形溢出，使用下面的逻辑求出mid
            int mid = l + (r - l) / 2;
            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] > k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 28, 79, 96, 98, 98};
        BinarySearch binarySearch = new BinarySearch();
        int i = binarySearch.search02(arr, 98);
        int j = binarySearch.search01(arr, 0, arr.length, 98);
        System.out.println(i);
        System.out.println(j);
    }
}
