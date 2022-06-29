package onjava8.f13_function_programming.impleInterface;

/**
 * @author chenyuqun
 * @date 2021/6/1 11:21 上午
 */
public class Reverse {
    static class A {
        String a;

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }
    }

    public static void main(String[] args) {
        A a = new A();
        a.setA(null);
        System.out.println(a.getA());
    }

    public static String reverse(String arg) {
        if(arg.length() == 0) {
            return arg;
        }
        return reverse(arg.substring(1)) + arg.charAt(0);
    }
}
