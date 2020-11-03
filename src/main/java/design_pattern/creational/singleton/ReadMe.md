### 什么是单例
一个类只允许创建一个实例
### 应用场景
处理资源访问冲突
表示全局唯一类,比如配置信息类，唯一递增ID号码生成器。
### 实现方式
1、饿汉: 基本，枚举
2、懒汉：synchronized(并发度高) -> 双重检测（实现复杂）-> 静态内部类（既解决了并发度高的问题，实现起来也简单，Instance的唯一性和创建过程的线程安全性都由jvm保证）

### 集群环境
+ 单例模式的唯一性指的是进程唯一性。
+ 如何实现线程唯一的单例？
    用HashMap，key是线程的id, value是对象.
+ 如何实现集群唯一的单例？
    - 集群唯一：进程间唯一，不同的进程共享同一个对象。
    - 单例对象序列化并存储在共享存储区。一个进程获得这个对象之后需要对这个对象加锁，用完之后，显示的删除对象并且释放锁。
+ 如何实现一个多例模式？
    - 一个类可以创建多个对象，但是对象的数量是有限的。
    - 多例模式创建的是同一个类的对象，工厂模式创建的是不同子类的对象。
    