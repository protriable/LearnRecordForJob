package org.example.singleton;

/**
 * 懒汉式单例模式
 * 步骤：
 *  1.构造器私有化
 *  2.定义一个静态变量存储一个单例对象-但是不初始化
 *  3.定义一个获取单例对象的方法，如果对象为null则创建对象，否则直接返回对象
 * 线程不安全-不推荐
 */
public class LazySingleton04 {

   private static LazySingleton04 INSTANCE = null;

   private LazySingleton04(){}

   public static LazySingleton04 getInstance() {
       if (INSTANCE == null) {
           INSTANCE = new LazySingleton04();
       }
       return INSTANCE;
   }

}
