package com.example.Test_10;

/**
 * autour: 夏奇顶
 * date: 2016-11-30 19:11
 * update: 2016-11-30
 */
//求100之内的素数 //使用除sqrt(n)的方法求出的素数不包括2和3
public class Test {

    public static void main(String[] args) {
        for (int i = 2; i <100 ; i++) {
            int j;
            for (j = 2; j < Math.sqrt(i); j++) {
                if (i%j==00)
                    break;
            }
            if (j>Math.sqrt(i)){
                System.out.println(i);
            }
        }
    }
}
