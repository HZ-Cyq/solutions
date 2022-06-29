package onjava8.f19_type_info._interface.inner;

import onjava8.f19_type_info._interface.A;
import onjava8.f19_type_info._interface.HiddenAnonymous;

import java.lang.reflect.InvocationTargetException;

import static onjava8.f19_type_info._interface.inner.HiddenImplementation.calHiddenMethod;

/**
 * @author chenyuqun
 * @date 2021/5/21 10:08 上午
 */
public class AnonymousImplementation {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        A a = HiddenAnonymous.makeAnonymous();
        calHiddenMethod(a,"f");
        calHiddenMethod(a,"g");
        calHiddenMethod(a,"u");
        calHiddenMethod(a,"v");
        calHiddenMethod(a,"w");
    }
}
