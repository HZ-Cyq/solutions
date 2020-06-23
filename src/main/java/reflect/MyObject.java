package reflect;

/**
 * @author playcrab_chenyuqun
 */
public class MyObject extends  MyObjectBase implements MyObjectsInterface {
    String attribute1;
    public MyObject() {

    }
    public MyObject(String attribute1) {
        this.attribute1 = attribute1;
    }
    public void method1() {
        System.out.println("MyObject.method1");
    }

    public void method2() {
        System.out.println("MyObject.method2");
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    @Override
    public void printSelf() {
        System.out.println("attribute1: "+ attribute1);
    }
}
