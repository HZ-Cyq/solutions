package books.onjava8.f19_type_info._interface._field;

/**
 * @author chenyuqun
 * @date 2021/5/21 10:40 上午
 */
public class WithPrivateFinalField {
    private int privateInt = 1;
    private final int privateFinalInt = 1;
    private String privateStr = "hello";
    private final String privateFinalStr = "hello";

    @Override
    public String toString() {
        return "WithPrivateFinalField{" +
                "privateInt=" + privateInt +
                ", privateFinalInt=" + privateFinalInt +
                ", privateStr='" + privateStr + '\'' +
                ", privateFinalStr='" + privateFinalStr + '\'' +
                '}';
    }
}
