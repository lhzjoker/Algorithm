package com.lhz.Algorithm;


/**
 * @author lhz
 * @version 1.0
 * @date 2020/7/8 22:19
 */
public class Test implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        Test test1 = new Test();
//        Test test2 = new Test();
        Thread t1 = new Thread(test1, "A");
        Thread t2 = new Thread(test1, "B");
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("执行的是：" + Thread.currentThread().getName() + i);
            if (i == 5) {
                System.out.println("当前线程是：" + Thread.currentThread().getName());
                Thread.yield();
            }
        }
    }
}
