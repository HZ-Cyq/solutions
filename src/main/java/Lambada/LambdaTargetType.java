package Lambada;

public class LambdaTargetType {

    @FunctionalInterface
    interface A {
        void a();
    }

    @FunctionalInterface
    interface B {
        void b();
    }

    static class UseAB {
        void use(A a) {
            System.out.println("Use A");
        }

        void use(B b) {
            System.out.println("Use B");
        }
    }

    public static void main(String[] args) {
        UseAB useAB = new UseAB();
        A a = () -> System.out.println("Use");
        useAB.use(a);
    }
}
