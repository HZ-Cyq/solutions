package books.onjava8.f19_type_info._interface;

/**
 * @author chenyuqun
 * @date 2021/5/21 10:07 上午
 */
public class HiddenAnonymous {
    // 返回一个匿名类
    public static A makeAnonymous() {
        return new A() {
            @Override
            public void f() {
                System.out.println("anonymous.f()");
            }

            public void g() {
                System.out.println("anonymous.g()");
            }

            void u() {
                System.out.println("anonymous.u()");
            }

            protected void v() {
                System.out.println("anonymous.v()");
            }

            private void w() {
                System.out.println("anonymous.w()");
            }
        };
    }
}
