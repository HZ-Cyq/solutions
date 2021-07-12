package onjava8.f19_type_info._interface;

/**
 * @author chenyuqun
 * @date 2021/5/20 6:07 下午
 */
class C implements A{

    @Override
    public void f() {
        System.out.println("C.f()");
    }

    public void g() {
        System.out.println("C.g()");
    }

    void u() {
        System.out.println("C.u()");
    }

    protected void v() {
        System.out.println("C.v()");
    }

    private void w() {
        System.out.println("C.w()");
    }
}
