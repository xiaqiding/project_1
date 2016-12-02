package com.example.java_day_3.test_4;

/**
 * autour: 夏奇顶
 * date: 2016-12-01 19:33
 * update: 2016-12-01
 */
//线程状态转换
    /*
    *用案例解释线程的六种运行状态,其中Pig类实现Runnable接口，逻辑是打印当前运行的线程信息，
每隔一秒打印一次。在Main方法中启动十个Pig线程设置相应的线程优先级别，并且将初始的线程状态
保存到线程状态数组中，在运行的过程判断当前线程状态和初始状态是否相同，如果不同则打印当前线
程的信息保存到日志文件中。
    *
     */
class MyRunnable implements Runnable{
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                //线程进行休眠一秒
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印当前执行线程信息
        System.out.println("ThreadName :"  + Thread.currentThread().getName());
    }
}

public class Test {

    public static void main(String[] args) throws Exception {
        //创建数组
        Thread[] task = new Thread[10];
        //线程状态数组
        Thread.State[] states = new Thread.State[10];
        //设置线程状态
        for (int i = 0; i < 10; i++) {
            task[i] = new Thread(new MyRunnable());
            //分别设置状态
            if ((i % 3) == 0) {
                task[i].setPriority(Thread.NORM_PRIORITY);
            } else if ((i % 3) == 1) {
                task[i].setPriority(Thread.MIN_PRIORITY);
            } else if ((i % 3) == 2) {
                task[i].setPriority(Thread.MAX_PRIORITY);
            }
        }
        //循环遍历获取线程的信息
        for (int i = 0; i < 10; i++) {
            System.out.println("线程:" + i + "状态:" + task[i].getState());
            //将将当前线程状态保存到状态数组中
            states[i] = task[i].getState();

        }
        //启动线程
        for (int i = 0; i < 10; i++) {
            task[i].start();
        }

    }
}
