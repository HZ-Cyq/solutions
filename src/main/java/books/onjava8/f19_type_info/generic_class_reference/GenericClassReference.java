package books.onjava8.f19_type_info.generic_class_reference;

/**
 * @author chenyuqun
 * @date 2021/5/15 2:37 下午
 */
public class GenericClassReference {
    public static void main(String[] args) {
        Class<? extends Number> genericClassRef = int.class;
        Class<?> classRef = int.class;
        // 如果有限定，被注掉的下面这行编译不过
        // genericClassRef = double.class;
        // 没有限定。不会报错
        classRef = double.class;
    }
}
