package books.onjava8.f13_function_programming.impleInterface.method_reference.unbound_method_reference;

import com.google.common.base.Function;

/**
 * @author chenyuqun
 * @date 2021/5/28 10:42 上午
 */
public class UnboundMethodReference {
    public static void main(String[] args) {
        // 这里的X::f就是未绑定的方法引用，X::f有一个隐藏参数this，因为我们不能在没有X对象的前提下调用f()。下面这行编译会报错。
        // MakeString ms = X::f;

        // 它的本质是这样的一个function。传入X，返回String的function。
        // 方法引用和接口签名（参数类型和返回值）一致，就可以用方法引用赋值接口。
        Function<X, String> f = X::f;
        // X::f这个方法引用和TransformX的接口签名一致，所以可以赋值。
        TransformX sp = X::f;
        X x = new X();
        // 下面两个的输出是一样的，因为方法实现一样，输入参数一样，所有输出也一样
        System.out.println(sp.transformX(x));
        System.out.println(x.f());
    }
}
