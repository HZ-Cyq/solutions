package design_pattern.behavioral.visitor.double_dispatch;

/**
 * 执行哪个对象的哪个方法，singleDispatch可以在运行时确定哪个对象，不可以再运行时确定哪个方法(java,C++)
 * doubleDispatch可以在运行时确定哪个对象，也可以在运行时确定哪个方法。
 * Double Dispatch的语言不需要访问者模式。
 *
 * @author chenyuqun
 */
public class DispatchTest {
    public static void main(String[] args) {
        SingleDispatch demo = new SingleDispatch();
        ParentClass p = new ChildClass();
        // 可以调用子类的f方法
        demo.polymorphismFunction(p);
        // 这里的p匹配到这个方法Function(ParentClass p)
         demo.overloadFunction(p);
    }
}
