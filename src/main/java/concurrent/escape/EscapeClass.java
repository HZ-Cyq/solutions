package concurrent.escape;

/**
 * @author chenyuqun
 */
public class EscapeClass {

    private int a;

    public EscapeClass(EscapeClassUser escapeClassUser) {
        escapeClassUser.addAEscapeClass(this);
        a = 3;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public static void main(String[] args) {
        EscapeClassUser escapeClassUser = new EscapeClassUser();
        EscapeClass escapeClass = new EscapeClass(escapeClassUser);
        // 这个时候输出来的A是3,值没有加1
        System.out.println(escapeClass.getA());
    }
}
