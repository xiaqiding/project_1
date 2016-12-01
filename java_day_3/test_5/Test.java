package com.example.java_day_3.test_5;

/**
 * autour: 夏奇顶
 * date: 2016-12-01 20:24
 * update: 2016-12-01
 */
//线程调度
public class Test {

    public static void main(String[] args) {
        Thread thread=new MyThread();
        thread.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("主线程第" + i + "次执行！");
            if (i>2){
                //t1线程合并到主线程中，主线程停止执行过程，转而执行t1线程，直到t1执行完毕后继续。
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
class MyThread extends Thread{
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("线程1第" + i + "次执行！");
        }
    }
}
