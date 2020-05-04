package javabase.inherit;

/**
 * @author playcrab_chenyuqun
 */
public class Son extends Father {
    public Son(int a) {
        super(a);
    }
    public void printA() {
        System.out.println(this.getA());
    }
}
