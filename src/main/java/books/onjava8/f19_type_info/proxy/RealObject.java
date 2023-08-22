package books.onjava8.f19_type_info.proxy;

/**
 * @author chenyuqun
 * @date 2021/5/20 3:33 下午
 */
public class RealObject implements Interface {
    @Override
    public void doSomeThing() {
        System.out.println("doSomeThing");
    }

    @Override
    public void someThingElse(String arg) {
        System.out.println("someThingElse " + arg);
    }
}
