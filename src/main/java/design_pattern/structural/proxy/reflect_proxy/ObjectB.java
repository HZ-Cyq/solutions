package design_pattern.structural.proxy.reflect_proxy;

/**
 * @author chenyuqun
 * @date 2020/11/10 6:16 下午
 */
public class ObjectB implements ObjectA{
    @Override
    public void print(String str) {
        System.out.println("ObjectB execute print method");
    }
}
