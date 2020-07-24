package com.lhz.Algorithm.Practice;

/**
 * @author lhz
 * @version 1.0
 * @date 2020/7/22 20:56
 * 一个数组中（无序），求这个数组中第k大的元素
 * 普通的方法就是先给它排序，如何能让他高效呢，这里我们用快速排序的思想
 */
public class Selection {
    public static int partition(int[] arr,int l,int r){
        //这里还可以做优化，取随机基准数
        int temp = arr[l];
        while(l<r){
            while (l<r && temp<=arr[r]){
                r--;
            }
            if(l<r){
                arr[l] = arr[r];
                l++;
            }
            while(l<r && temp>=arr[l]){
                l++;
            }
            if(l<r){
                arr[r] = arr[l];
                r--;
            }
        }
        arr[l] = temp;
        return l;
    }

    //找第k大的元素
    public static int solve(int[] arr,int l,int r,int k){
        if(l==r){
            return arr[l];
        }
        // partition之后, nums[p]的正确位置就在索引p上
        int p = partition(arr,l,r);
        if(p==k){
            // 如果 k == p, 直接返回nums[p]
            return arr[p];
        }else if(k<p){
            //如果 k < p, 只需要在nums[l...p-1]中找第k小元素即可
            return solve(arr,l,p-1,k);
        }else{
            return solve(arr,p+1,r,k);
        }
    }

    public static int solve(int[] arr,int k){
        assert arr!=null && k>=0 && k<arr.length;
        return solve(arr,0,arr.length-1,k-1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,8,6,0,3,7};
        int solve = solve(arr,4);
        System.out.println(solve);
    }
}
