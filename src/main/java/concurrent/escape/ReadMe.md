java中的发布与逃逸
参考: https://www.cnblogs.com/yulinfeng/p/5975728.html
publish: 提供一个对象的引用给作用域之外的代码
escape: 一个类还没有构造结束就发布了该对象。
    在没完成对象初始化的时候，不要把对象的引用传给给别的方法。
