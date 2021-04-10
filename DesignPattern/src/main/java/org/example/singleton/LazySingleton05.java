package org.example.singleton;

/**
 * 懒汉式单例模式
 * 步骤：
 *  1.构造器私有化
 *  2.定义一个静态变量存储一个单例对象-但是不初始化
 *  3.定义一个获取单例对象的方法，如果对象为null则创建对象，否则直接返回对象
 * 线程安全-不推荐-性能差
 */
public class LazySingleton05 {

   private static LazySingleton05 INSTANCE = null;

   private LazySingleton05(){}

   public static synchronized LazySingleton05 getInstance() {
       if (INSTANCE == null) {
           INSTANCE = new LazySingleton05();
       }
       return INSTANCE;
   }

}
