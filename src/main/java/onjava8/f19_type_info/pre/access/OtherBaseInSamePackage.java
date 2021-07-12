package onjava8.f19_type_info.pre.access;

/**
 * @author chenyuqun
 * @date 2021/5/25 8:42 下午
 */
public class OtherBaseInSamePackage {
    public static void main(String[] args) {
        Base base = new Base();
        // 在同一个包里，可以调用protected方法和default方法
        base.protectedMethod();
        base.defaultMethod();
    }
}
