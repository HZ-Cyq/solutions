package onjava8.f19_type_info.generic_class_reference.pets;

import onjava8.f19_type_info.generic_class_reference.pets.pet.Cat;
import onjava8.f19_type_info.generic_class_reference.pets.pet.Dog;
import onjava8.f19_type_info.generic_class_reference.pets.pet.Fish;
import onjava8.f19_type_info.generic_class_reference.pets.pet.Pet;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author chenyuqun
 * @date 2021/5/18 5:45 下午
 */
public class LiteralPetCreator extends Creator {
    public static final List<Class<? extends Pet>> ALL_TYPES = Collections.unmodifiableList(Arrays.asList(Cat.class, Dog.class, Fish.class));

    @Override
    public List<Class<? extends Pet>> types() {
        return ALL_TYPES;
    }
}
