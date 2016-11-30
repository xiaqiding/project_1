package com.example.test_7;

/**
 * autour: 夏奇顶
 * date: 2016-11-30 16:03
 * update: 2016-11-30
 */
//打印出杨辉三角形（要求打印出10行以上）

public class Test {

    public static void main(String[] args) {
        //三角的行数
        int row = 10;

        int[][] result = new int[row][row];

        for (int i = 0; i < row; i++) {    //行
            result[i][0] = 1;
            System.out.println(result[i][0] + " ");

            for (int j = 1; j <= i; j++) {  //列
                result[i][j] = result[i - 1][j - 1] + result[i - 1][j];
                System.out.println(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
