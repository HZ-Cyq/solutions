package design_pattern.structural.proxy.reflect_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * {@link Proxy}的测试用例
 *
 * @author chenyuqun
 * @date 2020/11/10 3:47 下午
 */
public class ProxyTest {
    public static void main(String[] args) {
        // 简版的代理，objectB代理proxiesObject。
        ObjectA proxiedObject = new ObjectB();
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("invocationHandler invoke method: " + method.getName());
                System.out.println("args:");
                for(Object object : args) {
                    System.out.println(object);
                }
                method.invoke(proxiedObject, args);
                return null;
            }
        };
        ObjectA objectB = (ObjectA) Proxy.newProxyInstance(ObjectB.class.getClassLoader(),new Class[]{ObjectA.class}, invocationHandler);
        objectB.print("hello");
    }
}
