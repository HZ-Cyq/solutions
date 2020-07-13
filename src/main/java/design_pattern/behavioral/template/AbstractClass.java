package design_pattern.behavioral.template;

/**
 * @author playcrab_chenyuqun
 */
public abstract class AbstractClass {

    public final void templateMethod() {
        method1();
        method2();
    }

    protected abstract void method2();
    protected abstract void method1();

}
