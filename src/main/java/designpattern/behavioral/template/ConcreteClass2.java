package designpattern.behavioral.template;

/**
 * @author playcrab_chenyuqun
 */
public class ConcreteClass2 extends AbstractClass{
    @Override
    protected void method2() {
        System.out.println("ConcreteClass2 execute method2");
    }

    @Override
    protected void method1() {
        System.out.println("ConcreteClass2 execute method1");
    }
}
