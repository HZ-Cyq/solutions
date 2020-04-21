package designpattern.behavioral.template;

/**
 * @author playcrab_chenyuqun
 */
public class ConcreteClass1 extends AbstractClass {
    @Override
    protected void method2() {
        System.out.println("ConcreteClass1 execute method2");
    }

    @Override
    protected void method1() {
        System.out.println("ConcreteClass1 execute method1");
    }

}
