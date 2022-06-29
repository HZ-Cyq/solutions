package test.mock;

/**
 * @author chenyuqun
 * @date 2021/1/8 4:51 下午
 */
public class ClassA {
    int a;
    String str;
    public static int getOne() {
        return 1;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
        // 12329
    }
}
