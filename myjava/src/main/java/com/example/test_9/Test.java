package com.example.test_9;

/**
 * autour: 夏奇顶
 * date: 2016-11-30 18:41
 * update: 2016-11-30
 */
//有n个人围成一圈，顺序排号。从第一个人开始报数（从1到3报数），凡报到3的人退出圈子，问最后留下的是原来第几号的那位

public class Test {

    public static void main(String[] args) {
        int n=1;
        boolean[] arr=new boolean[n];
        //计数
        int countNum=0;
        //数到的位置
        int index=0;
        //数字队列剩余
        int arrlength=arr.length;
        System.out.println(arr[arrlength-1]);
        for (int i = 0; i <arr.length ; i++) {
            // 把数组的值得全部置为true
            arr[i]=true;
        }
        //留下最后一个
        while (arrlength>1){
            if (arr[index]==true){
                //从1开始计数
                countNum++;
                //从1开始的，数到3就是第三个数字了
                if (countNum==3){
                    // 数到第三个数，把它的值变为false
                    arr[index]=false;
                    // 数组长度减去1
                    arrlength--;
                    //重新计数
                    countNum=0;
                }
            }
            //每判断一个，加一
            index++;
            // 判断是否到了最后的数字，到了,重新从0开始
            if (index==arr.length){
                index=0;
            }
        }
        // 打印数组中有true值的那个下标值，即最后那个是第几个
        for (int j = 0; j <arr.length ; j++) {
            if (arr[j]==true){
                System.out.println("最后留下来的是第"+String.valueOf(j+1)+"个");
            }
        }
    }
}
