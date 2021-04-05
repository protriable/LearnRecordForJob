package com.example.volatiles;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author protry
 * @className VolatileExample2.java
 * @description
 *  目标：使用原子类实现共享变量的原子性操作
 * @createTime 2021年04月05日 15:49:00
 */
public class VolatileExample4 {


    public static void main(String[] args) {

        final Runnable target = new ThreadTarget3();
        for (int i = 0; i < 100; i++) {
            new Thread(target, "第" + i + "个线程").start();
        }
    }
}

//线程任务类
class ThreadTarget3 implements Runnable {

    //提供一个原子类
    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName() +
                    "========== count=" + atomicInteger.incrementAndGet());
        }
    }
}
