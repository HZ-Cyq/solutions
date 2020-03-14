Guava EventBus的使用 
1、创建（同步阻塞类的EventBus和异步非阻塞类的AsyncEventBus两种）
    同步：观察者方法没执行完，被观察者方法不会继续执行，会被阻塞
    异步；观察者方法没执行完，被观察者方法可以继续执行，不会被阻塞
2、register方法：在eventBus中注册观察者。
3、post方法：将更新信息发送给观察者。

参考：观察者模式下：如何实现一个异步非阻塞的EventBus框架：
https://time.geekbang.org/column/article/211239
