package onjava8.f19_type_info._interface._field;

import java.lang.reflect.Field;

/**
 * @author chenyuqun
 * @date 2021/5/21 10:41 上午
 */
public class ModifyingPrivateFields {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        WithPrivateFinalField pf = new WithPrivateFinalField();
        System.out.println(pf);

        Field privateInt = pf.getClass().getDeclaredField("privateInt");
        Field privateFinalInt = pf.getClass().getDeclaredField("privateFinalInt");
        Field privateStr = pf.getClass().getDeclaredField("privateStr");
        Field privateFinalStr = pf.getClass().getDeclaredField("privateFinalStr");

        privateInt.setAccessible(true);
        privateFinalInt.setAccessible(true);
        privateStr.setAccessible(true);
        privateFinalStr.setAccessible(true);

        privateInt.setInt(pf,3);
        privateFinalInt.setInt(pf,3);
        privateStr.set(pf,"world");
        privateFinalStr.set(pf,"world");
        System.out.println(pf);
    }
}
