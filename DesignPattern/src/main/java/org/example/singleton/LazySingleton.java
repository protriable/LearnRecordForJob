package org.example.singleton;

/**
 * 懒汉式单例模式
 */
public class LazySingleton {

    /**
     * 保证instance 在所有线程中同步，volatile保证数据的可见性不保证原子性
     */
    private static volatile LazySingleton instance = null;

    /**
     * private 避免类在外部被实例化
     */
    private LazySingleton(){}

    /**
     * getInstance 方法前加同步
     * @return 返回LazySingleton 实例
     */
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
