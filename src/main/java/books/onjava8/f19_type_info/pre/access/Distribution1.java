package books.onjava8.f19_type_info.pre.access;

/**
 * @author chenyuqun
 * @date 2021/5/20 8:49 下午
 */
public class Distribution1 extends Base{

    @Override
    void defaultMethod() {
       super.defaultMethod();
    }

    @Override
    protected void protectedMethod() {
        super.protectedMethod();
    }

    public static void main(String[] args) {
        Base base = new Base();
        base.protectedMethod();
        base.defaultMethod();
    }
}
