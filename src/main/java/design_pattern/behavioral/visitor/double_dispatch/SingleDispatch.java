package design_pattern.behavioral.visitor.double_dispatch;

/**
 * @author chenyuqun
 */
public class SingleDispatch {
    public void polymorphismFunction(ParentClass p) {
        p.f();
    }

    public void overloadFunction(ParentClass p) {
        System.out.println("I am overloadFunction(ParentClass p)");
        p.f();
    }

    public void overloadFunction(ChildClass c) {
        System.out.println("I am overloadFunction(ChildClass c)");
    }
}
