package com.example;

public class MyClass {

    int MySalary=14000;
    double percent=0.1f;

    public void textSum(){
        double SUM = MySalary * percent*2;
        System.out.printf("月公积金----->"+SUM);
    }

    //递归
    int doSum(int n){
        if(n==100){
            return n;
        }
        return n+doSum(n+1);
    }


    public static void main(String[] args) {
        //算法
            new MyClass().textSum();

        //二分法
        int[] nums = { 2, 5, 11, 3, 22, 6, 91, 13, 35, 4 };
//        //对数组进行排序
//        QuickSort.sort(nums, 0, nums.length-1);

        int find = MyClass.search(nums,5);

        if (find != -1) {
            System.out.println("\n找到数值于索引" + find);
        } else {
            System.out.println("找不到数值");
        }


        //1--100递归算法
        new MyClass().doSum(1);

        //1--100递归算法
        System.out.printf(String.valueOf("----------->"+dg(100)));

        //1--100递归算法
        new MyClass().doSum(1);

    }



    //1--100递归算法
    static int dg(int i) {     /*定义变量 */
        int sum;
        if (i == 1)         /*假设条件*/
            return 1;
        else
            sum = i + dg(i - 1);     /*1~100的和的表达式*/
        return sum;              /*返回结果*/
    }



    //二分法
    public static int search(int[] nums, int num) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            //与中间值比较确定在左边还是右边区间,以调整区域
            if (num > nums[mid]) {
                low = mid + 1;
            } else if (num < nums[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }




}