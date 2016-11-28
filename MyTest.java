package com.bwie.myerfenfa;

/**
 * 作用:
 * 作者:
 * 时间:
 */

public class MyTest {

    public static void main(String[] args) {
        int[] arr={1,2,5,9,11,45};
        int index=findIndext(arr,0,arr.length-1,12);
        System.out.println("index="+index);
    }
    // 1. 实现一个函数，在一个有序整型数组中二分查找出指定的值，找到则返回该值的位置，找不到返回 -1。
    public static int findIndext(int[] arr,int left,int right,int abc){
        if(arr==null||arr.length==0){
            return -1;
        }
        if(left==right){
            if(arr[left]!=abc){
                return -1;
            }
        }
        int mid=left+(right-left)/2;//3//4
        if(arr[mid]>abc){//
            right=mid-1;
            return findIndext(arr,left,right,abc);
        }else if(arr[mid]<abc){  //5<45//9<45/11<45
            left=mid+1;
            return findIndext(arr,left,right,abc);  //2,5//3,5//4.5
        }else{
            return mid;
        }
    }
}
