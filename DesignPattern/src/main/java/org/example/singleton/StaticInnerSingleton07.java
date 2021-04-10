package org.example.singleton;

/**
 * @author protry
 * @className StaticInnerSingleton07.java
 * @description
 *  目标： 研究静态内部类单例模式
 *  原理：JVM在类初始化阶段(即Class被加载后，线程使用前)，会执行类初始化，在执行类的初始化期间，
 *      JVM会去获取一个锁，这个锁可以同步多个线程对同一个类的初始化
 *  步骤：
 *      1.私有化构造器
 *      2.提供一个静态内部类，里面提供一个常量存储一个单例对象
 *      3.提供一个静态方法返回静态内部类中的单例对象
 * @createTime 2021年04月07日 21:27:00
 */
public class StaticInnerSingleton07 {

    private StaticInnerSingleton07(){}

    public static StaticInnerSingleton07 getInstance() {
        return InnerSingleton.INSTANCE;
    }

    /**
     * 被调用的时候才会去加载静态内部类，调用的时候通过JVM获取的唯一锁实现线程安全问题
     */
    private static class InnerSingleton {
        private static final StaticInnerSingleton07 INSTANCE = new StaticInnerSingleton07();
    }

}
