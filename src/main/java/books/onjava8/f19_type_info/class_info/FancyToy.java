package books.onjava8.f19_type_info.class_info;

/**
 * @author chenyuqun
 * @date 2021/5/12 8:14 下午
 */
public class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots{
    FancyToy() {
        super(1);
    }
}
