package concurrent.escape;

/**
 * @author chenyuqun
 */
public class EscapeClassUser {

    public void addAEscapeClass(EscapeClass escapeClass) {
        escapeClass.setA(escapeClass.getA() + 1);
    }
}
