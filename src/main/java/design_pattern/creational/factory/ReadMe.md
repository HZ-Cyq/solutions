### 工厂模式
定义了一个创建对象的接口，将对象的创建分离出来。

+ 简单工厂
   - 两种实现方法
+ 工厂方法
    
什么时候使用工厂方法模式，什么时候使用简单工厂模式？
工厂方法模式比简单工厂模式更加符合开闭原则
当对象的创建逻辑比较复杂，不只是简单的new一下就可以，而要组合其他类对象，做各种初始化操作的时候，使用工厂方法模式。
将复杂的创建逻辑拆分到多个工厂类中，

+ 抽象工厂
    一个工厂创建多个不同的类型的对象
    
判断要不要使用工厂模式的标准

+ 封装变化：创建逻辑有可能变化，封装成工厂类之后，创建逻辑的变更对调用者透明。
+ 代码复用：创建代码抽离到独立的工厂类之后可以复用。
+ 隔离复杂性：封装复杂的创建逻辑，调用者无需了解如何创建对象。
+ 控制复杂度：将创建代码抽离出来，让原本的函数或类职责更单一，代码更简洁。

+ 将创建逻辑分离出来的好处：
    + 调用者不用考虑创建过程，创建逻辑复杂或者创建逻辑发生了变化，调用者都无需考虑。
