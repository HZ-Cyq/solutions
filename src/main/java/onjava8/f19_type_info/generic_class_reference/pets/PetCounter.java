package onjava8.f19_type_info.generic_class_reference.pets;

import onjava8.f19_type_info.generic_class_reference.pets.pet.Cat;
import onjava8.f19_type_info.generic_class_reference.pets.pet.Dog;
import onjava8.f19_type_info.generic_class_reference.pets.pet.Fish;
import onjava8.f19_type_info.generic_class_reference.pets.pet.Pet;

import java.util.HashMap;
import java.util.stream.Stream;

/**
 * @author chenyuqun
 * @date 2021/5/17 8:42 下午
 */
public class PetCounter {
    static class Counter extends HashMap<String, Integer> {
        public void count(String type) {
            Integer quantity = get(type);
            if (quantity == null)
                put(type, 1);
            else
                put(type, quantity + 1);
        }

        @Override
        public String toString() {
            String re = "";
            for (Entry<String, Integer> entry : entrySet()) {
                re += "[" + entry.getKey() + "]" + ": [" + entry.getValue() + "]\n";
            }
            return re;
        }
    }

    private Counter counter = new Counter();

    private void countPets(Pet pet) {
        if (pet instanceof Cat) {
            counter.count("Cat");
        } else if (pet instanceof Dog) {
            counter.count("Dog");
        } else if (pet instanceof Fish) {
            counter.count("Fish");
        } else {
            throw new RuntimeException("count 错误，不是指定类型:{}" + pet.getClass().getSimpleName());
        }
    }

    public void count(Creator creator) {
        Stream.generate(creator).limit(20).forEach(this::countPets);
        System.out.println(counter);
    }

    public static void main(String[] args) {
        new PetCounter().count(new ForNamePetCreator());
    }

}
