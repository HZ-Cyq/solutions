package books.onjava8.f13_function_programming.impleInterface.recurison;

/**
 * @author chenyuqun
 * @date 2021/5/27 6:33 下午
 */
public class RecursiveFactorial {
    static IntCall staticFact;
    IntCall intCall;

    public static void main(String[] args) {
        // 递归的lambda表达式，可以是静态变量或者实例变量，但是不能是局部变量
        staticFact = n -> n == 0 ? 1 : staticFact.cal(n - 1) * n;
        RecursiveFactorial recursiveFactorial = new RecursiveFactorial();
        recursiveFactorial.intCall = n -> n == 0 ? 1 : recursiveFactorial.intCall.cal(n - 1) * n;
        // 局部变量，下面这行会报错。无法编译.
        //IntCall intCall1 = n -> n == 0 ? 1 : intCall1.cal(n - 1) * n;

        System.out.println(staticFact.cal(5));
        System.out.println(recursiveFactorial.intCall.cal(5));
    }
}
