package com.example.java_day_3.test_3;

/**
 * autour: 夏奇顶
 * date: 2016-12-01 19:14
 * update: 2016-12-01
 */
//Thread和Runnable的区别
    /*
    实现Runnable的， 相当于是拿出一个卖票10张得任务给三个人去共同完成，
    new MyThread相当于创建一个任务，然后实例化三个Thread，创建三个线程即安排三个窗口去执行。
     */
class Myrunnable implements Runnable{

    private int ticket =10;
    private String name;

    public void run() {
        for (int i = 0; i < 500; i++) {
            if (this.ticket>0){
                System.out.println(Thread.currentThread().getName()+"卖票---->"+(this.ticket--));
            }
        }
    }
}
public class Runnable_test {

    public static void main(String[] args) {
        Myrunnable mr=new Myrunnable();

        Thread t1=new Thread(mr,"一号窗口");
        Thread t2=new Thread(mr,"二号窗口");
        Thread t3=new Thread(mr,"三号窗口");

        t1.start();
        t2.start();
        t3.start();
    }
}
