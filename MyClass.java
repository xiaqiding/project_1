package com.example;

public class MyClass {

    int MySalary=14000;
    double percent=0.1f;

    public void textSum(){
        double SUM = MySalary * percent*2;
        System.out.printf("�¹�����----->"+SUM);
    }

    //�ݹ�
    int doSum(int n){
        if(n==100){
            return n;
        }
        return n+doSum(n+1);
    }


    public static void main(String[] args) {
        //�㷨
            new MyClass().textSum();

        //���ַ�
        int[] nums = { 2, 5, 11, 3, 22, 6, 91, 13, 35, 4 };
//        //�������������
//        QuickSort.sort(nums, 0, nums.length-1);

        int find = MyClass.search(nums,5);

        if (find != -1) {
            System.out.println("\n�ҵ���ֵ������" + find);
        } else {
            System.out.println("�Ҳ�����ֵ");
        }


        //1--100�ݹ��㷨
        new MyClass().doSum(1);

        //1--100�ݹ��㷨
        System.out.printf(String.valueOf("----------->"+dg(100)));

        //1--100�ݹ��㷨
        new MyClass().doSum(1);

    }



    //1--100�ݹ��㷨
    static int dg(int i) {     /*������� */
        int sum;
        if (i == 1)         /*��������*/
            return 1;
        else
            sum = i + dg(i - 1);     /*1~100�ĺ͵ı��ʽ*/
        return sum;              /*���ؽ��*/
    }



    //���ַ�
    public static int search(int[] nums, int num) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            //���м�ֵ�Ƚ�ȷ������߻����ұ�����,�Ե�������
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