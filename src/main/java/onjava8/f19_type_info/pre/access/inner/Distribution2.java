package onjava8.f19_type_info.pre.access.inner;

import onjava8.f19_type_info.pre.access.Base;

/**
 * @author chenyuqun
 * @date 2021/5/20 8:50 下午
 */
public class Distribution2 extends Base {
    /**
     * 不同包子类，protected方法不可以访问,下面的方法会报错
     */
//    @Override
//    void defaultMethod() {
//        super.defaultMethod();
//    }

    /**
     * 不同包子类，protected方法可访问,而且还可以把子类的访问权限改成public
     */
    @Override
    protected void protectedMethod() {
        super.protectedMethod();
    }

}
