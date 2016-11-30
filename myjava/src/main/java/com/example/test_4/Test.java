package com.example.test_4;

/**
 * autour: 夏奇顶
 * date: 2016-11-30 15:03
 * update: 2016-11-30
 */

//有1,2,3,4四个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
public class Test {

    public static void main(String[] args) {
        //定义变量
        int i=0;  //保存百位上的数
        int j=0;  //保存十位上的数
        int k=0;  //保存各位上的数
        int t=0;  //保存数字个数
        //百位数字取值循环范围
        for (i=1;i<=4;i++){
            //十位数字取值循环范围
            for (j=1;j<=4;j++){
                //个位数字取值循环范围
                for (k=1;k<=4;k++){
                    //无重复数字
                    if (i!=j && j!=k && i!=k){
                        //统计个数
                        t+=1;
                        //输出每个三位数
                        System.out.println(i*100+j*10+k);
                    }
                }
            }
        }
        //输出三位数的总个数
        System.out.println(t);
    }
}
