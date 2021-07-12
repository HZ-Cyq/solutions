package onjava8.f19_type_info._interface.inner;

import onjava8.f19_type_info._interface.A;
import onjava8.f19_type_info._interface.HiddenC;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author chenyuqun
 * @date 2021/5/20 6:10 下午
 */
public class HiddenImplementation {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        A a = HiddenC.makeA();
        a.f();
        // 在包的外部，无法读取C,无法将A转换成C,也就无法调用C中的方法
//        if (a instanceof C) {
//            C c = (C) a;
//            c.g();
//        }
        // 但是通过反射，仍然可以调用C中的方法。
        calHiddenMethod(a,"f");
        calHiddenMethod(a,"g");
        calHiddenMethod(a,"u");
        calHiddenMethod(a,"v");
        calHiddenMethod(a,"w");
    }

    public static void calHiddenMethod(Object o, String methodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = o.getClass().getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(o);
    }
}
