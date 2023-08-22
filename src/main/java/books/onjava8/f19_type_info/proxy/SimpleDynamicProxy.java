package books.onjava8.f19_type_info.proxy;

import java.lang.reflect.Proxy;

/**
 * @author chenyuqun
 * @date 2021/5/20 3:35 下午
 */
public class SimpleDynamicProxy {
    public static void consumer(Interface iface) {
        iface.doSomeThing();
        iface.someThingElse("hello");
    }

    public static void main(String[] args) {
        Interface realObj = new RealObject();
        consumer(realObj);
        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(), new Class[]{Interface.class}, new DynamicProxyHandler(realObj));
        consumer(proxy);
    }
}
