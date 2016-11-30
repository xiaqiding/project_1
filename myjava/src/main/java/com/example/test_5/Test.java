package com.example.test_5;

/**
 * autour: 夏奇顶
 * date: 2016-11-30 15:28
 * update: 2016-11-30
 */
//求1+2!+3!+...+20!的和
public class Test {

    public static void main(String[] args) {
        //定义变量
        int sum=0;
        int num=1;
        //遍历1-20
        for(int i=1;i<=20;i++){
           num=num*i;
            sum+=num;
        }
        System.out.println(sum);
    }
}
