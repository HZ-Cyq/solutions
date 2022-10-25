package generics;

import org.junit.Test;

public class GenericsTest2 {

    /**
     *  获得范型类的具体类型
     */
    @Test
    public void getGenericClassType() {
        Foo<String> foo = new Foo<String>(){};
        System.out.println(foo.getTClass());
    }
}
