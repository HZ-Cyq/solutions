获取java的参数类型Type：
+ Type指的是java.lang.reflect.Type,是java中所有类型的公共高级接口，代表了Java中的所有类型.
    + 原始类型
        + 实数: float,double
        + 整数: byte, short, int, long
        + 字符: char
        + 布尔值: boolean
    + 基本类型: 类、枚举、数组、注解等  
    + 通配符类型：<？>, <？ extends T> 等
    + 参数化类型: 泛型LIst、Map等
    + 数组类型：带有泛型的数组T[] (而不是平时用到的String[], byte[])
