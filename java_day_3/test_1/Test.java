package com.example.java_day_3.test_1;

/**
 * autour: 夏奇顶
 * date: 2016-12-01 18:29
 * update: 2016-12-01
 */
//java.lang.Thread类
public class Test extends Thread{
    private Thread t;
    private String threadName;

    Test( String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    public void run(){
        System.out.println("Running " +  threadName );
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                //让线程休息一会
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
        Test T1=new Test("Thread-1");
        T1.start();

        Test T2 = new Test( "Thread-2");
        T2.start();
    }
}
