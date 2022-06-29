package onjava8.f19_type_info.pre.access.inner;

import onjava8.f19_type_info.pre.access.Base;

/**
 * @author chenyuqun
 * @date 2021/5/25 8:43 下午
 */
public class OtherBaseInOtherPackage {
    public static void main(String[] args) {
        Base base = new Base();
        // 不在同一个包里，无法调用protected和default方法,下面两行都会报编译错误
//        base.defaultMethod();
//        base.protectedMethod();
    }
}
