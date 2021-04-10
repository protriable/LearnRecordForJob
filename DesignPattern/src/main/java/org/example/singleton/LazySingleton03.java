package org.example.singleton;

/**
 * 懒汉式单例模式
 * 线程安全-volatile双重锁机制
 */
public class LazySingleton03 {

    /**
     * 保证instance 在所有线程中同步，volatile保证数据的可见性，禁止重排序，不保证原子性
     */
    private static volatile LazySingleton03 instance = null;

    /**
     * private 避免类在外部被实例化
     */
    private LazySingleton03(){}

    /**
     *@return 返回LazySingleton 实例
     */
    public static synchronized LazySingleton03 getInstance() {
        //第一重锁检查
        if (instance == null) {
            //同步锁定代码块
            synchronized (LazySingleton06.class) {
                //第二重锁检查
                if (instance == null) {
                    //注意：非原子性操作
                    // 原因一 可能指令重排序导致先给引用对象
                    // 原因二 可见性，A线程在自己的工作内存中实例化了对象，可能还未同步到主内存，
                    //  导致线程B依然进入同步代码块
                    instance = new LazySingleton03();
                }
            }
        }
        return instance;
    }
}
