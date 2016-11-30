package com.example.test_3;

import java.util.Scanner;

/**
 * autour: 夏奇顶
 * date: 2016-11-30 19:29
 * update: 2016-11-30
 */
/*
古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，
小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，
问每个月的兔子总数为多少？
 */
public class Test {

    public static void main(String[] args) {
        // 定义这个月和下个月兔子的数量
        long s1,s2;
        //第一个月为一对
        s1=1;
        //第二个月为一对
        s2=1;
        //定义一个控制变量
        int i=1;
        //月份数
        int m;
        //从控制台输入想要查看的月份
        Scanner in=new Scanner(System.in);
        System.out.println("输入你想要查看的月数:");
        //输入的整数月份赋值给m
        m=in.nextInt();

        while (true){
            //第一个月和第二个月兔子的数量都为1对
            if (i==1||i==2){
                System.out.println(i+"month:"+s1);
                i++; // 控制变量 i 加1
            }else if (i<m){  // i 大于3并且小于我们需要查看的月份
                s1=s1+s2;
                s2=s1+s2;
                System.out.println(i+"month:"+s1);
                i++;//月份加1
                System.out.println(i+"month:"+s2);
                i++;
            }else {
                break;//不符合条件就退出
            }
        }
    }
}
