package books.onjava8.f19_type_info.class_info;

/**
 * @author chenyuqun
 * @date 2021/5/13 11:33 上午
 */
public class ClassLiteral {
    public static void main(String[] args) {
        FancyToy fancyToy = new FancyToy();
        System.out.println(FancyToy.class == fancyToy.getClass());

        System.out.println((Boolean.TYPE == boolean.class));
        System.out.println(Byte.TYPE == byte.class);
        System.out.println(Short.TYPE == short.class);
        System.out.println(Integer.TYPE == int.class);
        System.out.println(Long.TYPE == long.class);
        System.out.println(Character.TYPE == char.class);
        System.out.println(Float.TYPE == float.class);
        System.out.println(Double.TYPE == double.class);
    }
}
