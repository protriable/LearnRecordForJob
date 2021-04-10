package org.example.singleton;

/**
 * @author protry
 * @className HungarySingleton.java
 * @description 饿汉单例模式
 *  在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变，所以是线程安全的，可以直接用于多线程而不会出现问题。
 * @createTime 2021年04月04日 20:29:00
 */
public class HungarySingleton01 {

    private static final HungarySingleton01 instance = new HungarySingleton01();

    private HungarySingleton01(){}

    /**
     * @title 返回实例
     * @description
     * @author protry
     * @updateTime 2021/4/4 8:32 下午
     */
    public static HungarySingleton01 getInstance() {
        return instance;
    }
}
