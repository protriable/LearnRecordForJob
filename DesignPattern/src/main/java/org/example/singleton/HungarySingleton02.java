package org.example.singleton;

/**
 * @author protry
 * @className HungarySingleton02.java
 * @description
 *  目标：饿汉单例模式
 *  与 HungarySingleton01 一样的
 * @createTime 2021年04月07日 20:19:00
 */
public class HungarySingleton02 {

    private static HungarySingleton02 INSTANCE;

    static {
        INSTANCE = new HungarySingleton02();
    }

    private HungarySingleton02(){}

    public HungarySingleton02 getInstance() {
        return INSTANCE;
    }
}
