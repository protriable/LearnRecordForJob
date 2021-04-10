package com.example.volatiles;

/**
 * @author protry
 * @className VisibilityDemo1.java
 * @description 研究一下多线程下变量访问的不可见性
 *  准备内容：
 *      1.准备两个线程
 *      2.定义一个成员变量
 *      3.开启两个线程，其中一个线程负责修改，另外一个线程负责读取
 * @createTime 2021年04月04日 21:17:00
 */
public class VisibilityDemo1 {

    //main方法，作为主线程
    public static void main(String[] args) {
        // 1.开启子线程
        final MyThread t = new MyThread();
        t.start();

        // 2.主线程的执行
        while (true) {
            if (t.getFlag()) {
                System.out.println("主线程进入循环执行。。。。。。");
            }
        }
    }
}

class MyThread extends Thread{

    private boolean flag = false;
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