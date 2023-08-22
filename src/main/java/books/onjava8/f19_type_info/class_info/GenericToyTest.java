package books.onjava8.f19_type_info.class_info;

/**
 * @author chenyuqun
 * @date 2021/5/17 6:11 下午
 */
public class GenericToyTest {
    public static void main(String[] args) {
        Class<FancyToy> fancyToyClass = FancyToy.class;
        Class<? super FancyToy> superclass = fancyToyClass.getSuperclass();
    }
}
