package com.lhz.Algorithm.Practice;

import java.util.Arrays;

/**
 * @author lhz
 * @version 1.0
 * @date 2020/7/22 21:28
 * 求一个数组中有多少逆序对
 */
public class InversionNums {
    public static int merge(int[] arr,int l,int mid,int r){
        int[] aux = Arrays.copyOfRange(arr,l,r+1);
        int i = l,j = mid + 1;
        int res = 0;    //逆序对的个数
        for(int k=l;k<=r;k++){
            if(i>mid){
                arr[k] = aux[j-l];
                j++;
            }else if(j>r){
                arr[k] = aux[i-l];
                i++;
            }else if(aux[i-l]<aux[j-l]){
                arr[k] = aux[i-l];
                i++;
            }else {
                arr[k] = aux[j-l];
                j++;
                // 此时, 因为右半部分k所指的元素小
                // 这个元素和左半部分的所有未处理的元素都构成了逆序数对
                // 左半部分此时未处理的元素个数为 mid - j + 1
                res+=mid-i+1;
            }
        }
        return res;
    }

    public static int solve(int[] arr,int l,int r){
        if(l>=r){
            return 0;
        }
        int mid = (l+r)/2;
        // 求出 arr[l...mid] 范围的逆序数
        int res1 =  solve(arr,l,mid);
        // 求出 arr[mid+1...r] 范围的逆序数
        int res2 = solve(arr,mid+1,r);
        int res3 = merge(arr,l,mid,r);
        return res1+res2+res3;
    }

    public static int solve(int[] arr){
        return solve(arr,0,arr.length-1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,8,6,0,3,7};
        int solve = solve(arr);
        System.out.println(solve);
    }
}
