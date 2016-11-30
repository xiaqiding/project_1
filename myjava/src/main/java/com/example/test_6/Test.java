package com.example.test_6;

/**
 * autour: 夏奇顶
 * date: 2016-11-30 15:34
 * update: 2016-11-30
 */

//5位数中找出所有，判断它是不是回文数。即12321是回文数，个位与万位相同，十位与千位相同。
public class Test {

    public static boolean isPalindrome(int n){
        String num = Integer.toString(n);
        int len = num.length();
        int half = len/2;
        int is = 1;
        for (int i = 0; i < half; i++){
            if(num.charAt(i) != num.charAt(len-1-i)){
                is = 0;
                break;
            }
        }
        if(is == 1){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        for (int i = 10000; i <= 99999; i++) {

            if (isPalindrome(i)) {
                System.out.println(i);
            }
        }
    }
}
