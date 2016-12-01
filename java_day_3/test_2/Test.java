package com.example.java_day_3.test_2;

/**
 * autour: 夏奇顶
 * date: 2016-12-01 18:39
 * update: 2016-12-01
 */
//实现java.lang.Runnable接口

public class Test implements Runnable{

    private Thread t;
    private String threadName;

    Test( String name) {
        threadName = name;
        System.out.println("Creating " +  threadName );
    }

    @Override
    public void run() {
        System.out.println("Running " +  threadName );
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                //线程休息一会
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start(){
        System.out.println("Starting " +  threadName );
        if (t==null){
            t=new Thread(this,threadName);
            t.start();
        }
    }
}
class TestThread{
    public static void main(String[] args) {
        Test R1 = new Test( "Thread-1");
        R1.start();

        Test R2 = new Test( "Thread-2");
        R2.start();
    }
}
