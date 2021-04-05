package com.example.volatiles;

/**
 * @author protry
 * @className OutOfOrderDemo.java
 * @description
 *  目标：使用Volatile防止指令重排序
 * @createTime 2021年04月05日 21:50:00
 */
public class OutOfOrderDemo2 {

    //新建几个静态变量
    public volatile static int a=0, b=0;
    public volatile static int i=0, j=0;

    public static void main(String[] args) throws InterruptedException {
        //如果线程A先执行， a=1, i=0, b=1, j=1
        //如果线程B先执行， b=1, j=0, a=1, i=1
        //并发情况，a=1,b=1,i=1,j=1
        int count = 0;
        while (true) {
            count ++;
            i =0;
            j =0;
            a =0;
            b =0;
            //定义两个线程
            final Thread t1 = new Thread(() -> {
                a = 1;
                i = b;
            }, "线程A");

            final Thread t2 = new Thread(() -> {
                b = 1;
                j = a;
            }, "线程B");
            t1.start();
            t2.start();
            t1.join(); //让t1线程优先执行完毕
            t2.join(); //让t2线程优先执行完毕

            System.out.println("第" +count+ "次输出结果i=" + i + " j=" + j);
            if (i==0 && j==0) {
                break;
            }
        }
    }
}
