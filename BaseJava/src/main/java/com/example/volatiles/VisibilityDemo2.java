package com.example.volatiles;

/**
 * @author protry
 * @className VisibilityDemo1.java
 * @description 解决多线程下变量访问的不可见性
 *  解决思路
 *      1.加锁
 *          某一个线程进入synchronized代码块后
 *          1.线程获得锁
 *          2.清空工作内存
 *          3.从主内存拷贝最新共享变量到工作内存的副本中
 *          4.执行代码
 *          5.将修改后的副本值刷新回主内存中
 *          6.线程释放锁
 *      2.对共享变量使用volatile关键字修饰即可
 * @createTime 2021年04月04日 21:17:00
 */
public class VisibilityDemo2 {

    //main方法，作为主线程
    public static void main(String[] args) {
        // 1.开启子线程
        final MyThread2 t = new MyThread2();
        t.start();

        // 2.主线程的执行
        //method1
//        while (true) {
//            synchronized (t) {
//                if (t.getFlag()) {
//                    System.out.println("主线程进入循环执行。。。。。。");
//                }
//            }
//        }

        while (true) {
            if (t.getFlag()) {
                System.out.println("主线程进入循环执行。。。。。。");
            }
        }
    }
}

class MyThread2 extends Thread{

    //method1
//    private boolean flag = false;
    //method2
    private volatile boolean flag = false;
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //触发修改flag
        flag = true;
        System.out.println("flag =" + flag);
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}