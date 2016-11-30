package com.example.test_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * autour: 夏奇顶
 * date: 2016-11-30 14:39
 * update: 2016-11-30
 */
//输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。
public class Test {

    public static void main(String[] args) throws IOException{
        //键入文本
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        //按行读取
        String str=br.readLine();

        int countNum = 0;//统计数字的个数
        int countChar = 0;//统计英文字母的个数
        int countSpace = 0;//统计空格的个数
        int countOthers = 0;//统计其它字符的个数

        //分类循环统计
        for (int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if (c>='0' && (int)c<='9'){
                countNum++;
            }else if ((c>='a'&&c<='z')||(c>='A'&&c<='Z')){
                countChar++;
            }else if (c==' '){
                countSpace++;
            }else{
                countOthers++;
            }
        }
        //输出统计结果
        System.out.println("数字个数:"+countNum);
        System.out.println("英文字母个数:"+countChar);
        System.out.println("空格个数:"+countSpace);
        System.out.println("其他字符个数:"+countOthers);
    }
}
