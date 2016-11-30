package com.example.test_8;

/**
 * autour: 夏奇顶
 * date: 2016-11-30 16:46
 * update: 2016-11-30
 */
//计算字符串中子串出现的次数
public class Test {

    public static void main(String[] args) {
        String str="adasdeasfrweascdasqwasdfasedrtvfasxd";
        String str_1="as";
        int count=0;
        int start=0;
        while (str.indexOf(str_1,start)>=0&&start<str.length()){
            count++;
            start=str.indexOf(str_1,start)+str_1.length();
        }
        System.out.println(str_1+"在"+str+"出现的次数为"+count);
    }
}
