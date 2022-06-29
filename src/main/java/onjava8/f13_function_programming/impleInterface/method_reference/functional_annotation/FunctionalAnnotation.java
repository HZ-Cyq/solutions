package onjava8.f13_function_programming.impleInterface.method_reference.functional_annotation;

/**
 * @author chenyuqun
 * @date 2021/5/28 4:45 下午
 */
public class FunctionalAnnotation {
    public String goodbye(String arg) {
        return "GoodBye, " + arg;
    }

    public static void main(String[] args) {
        FunctionalAnnotation fa = new FunctionalAnnotation();
        Functional functional = fa::goodbye;
        FunctionalNoAnn fna = fa::goodbye;
        Functional f1 = a -> "Goodbye, " + a;
        FunctionalNoAnn fna1 = a -> "Goodbye, " + a;
    }
}
