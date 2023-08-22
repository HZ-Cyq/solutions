package books.onjava8.f19_type_info.generic_class_reference.pets;

import books.onjava8.f19_type_info.generic_class_reference.pets.pet.Pet;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author chenyuqun
 * @date 2021/5/18 4:16 下午
 */
public class ForNamePetCreator extends Creator {
    private static List<Class<? extends Pet>> types = Lists.newArrayList();
    private static String[] typeNames = {
            "onjava8.f19_type_info.generic_class_reference.pets.pet.Cat",
            "onjava8.f19_type_info.generic_class_reference.pets.pet.Dog",
            "onjava8.f19_type_info.generic_class_reference.pets.pet.Fish",
    };

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }

    static {
        loader();
    }

    @SuppressWarnings("unchecked")
    private static void loader() {
        for (String typeName : typeNames) {
            try {
                types.add((Class<? extends Pet>)Class.forName(typeName));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}

