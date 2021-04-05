package com.example.volatiles;

import org.springframework.util.StopWatch;

/**
 * @author protry
 * @className VolatileExample2.java
 * @description
 *  目标：研究Volatile的原子性操作
 *  基本观点：Volatile不能保证原子性操作
 *  操作流程：
 *      1.定义一个共享变量
 *      2.开启100个线程，每个线程负责为变量累加1万次
 *      3.线程执行完毕之后输出最终结果
 * @createTime 2021年04月05日 15:49:00
 */
public class VolatileExample3 {


    public static void main(String[] args) {

        final Runnable target = new ThreadTarget2();
        final long startMillTime = System.currentTimeMillis();
        final long nanoTime = System.nanoTime();
        System.out.println("startMillTime=" +startMillTime);
        System.out.println("nanoTime=" + nanoTime);
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 100; i++) {
            new Thread(target, "第" + i + "个线程").start();
        }
        final long endMillTime = System.currentTimeMillis();
        final long endNanoTime = System.nanoTime();
        stopWatch.stop();
        //毫秒
        System.out.println("millTime = " + (endMillTime - startMillTime));
        //纳秒
        System.out.println("nanoTime = " + (endNanoTime - nanoTime));
        //
        System.out.println("stopWatch=" + stopWatch.getTotalTimeNanos());
        System.out.println("stopWatch=" + stopWatch.getTotalTimeMillis());
        System.out.println("stopWatch=" + stopWatch.getTotalTimeSeconds());
    }
}

//线程任务类
class ThreadTarget2 implements Runnable {

    //定义共享变量
    private volatile int count = 0;

    @Override
    public void run() {
        synchronized (ThreadTarget2.class) {
            for (int i = 0; i < 10000; i++) {
                count++;
                System.out.println(Thread.currentThread().getName() + "========== count=" + count);
            }
        }
    }
}
