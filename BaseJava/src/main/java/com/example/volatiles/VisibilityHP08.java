package com.example.volatiles;

/**
 * @author protry
 * @className VisibilityHP8.java
 * @description
 *  目标：visibility写读建立的Happens-before 关系研究
 *  总规则：
 *      如果线程1写入了volatile变量V(临界资源),
 *      接着线程2读了了volatile变量V，那么线程1写入V之前的操作都对线程2可见(线程1和线程2可以是同一个线程)
 * @createTime 2021年04月06日 20:39:00
 */
public class VisibilityHP08 {

    private int a=1;
//    private int b=2;
    private volatile int b=2;

    public void write() {
        a = 3;
        b = a;
    }

    public void read() {
        System.out.println("b=" + b + " ,a=" + a);
    }

    public static void main(String[] args) {
        while (true) {
            final VisibilityHP08 hp08 = new VisibilityHP08();
            //写
            final Thread thread = new Thread(hp08::write);
            //读
            final Thread thread1 = new Thread(hp08::read);
            thread.start();
            thread1.start();
            try {
                thread.join();
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (hp08.a == 1) {
                break;
            }
        }
    }
}
