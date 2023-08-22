package books.onjava8.f19_type_info.generic_class_reference.cast;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author chenyuqun
 * @date 2021/5/17 6:27 下午
 */
public class ClassCasts {
    public static void main(String[] args) {
        House house = new House();
        Building building = house;
        List<Building> list = Lists.newArrayList();
        list.add(house);
        list.add(building);
    }

}
