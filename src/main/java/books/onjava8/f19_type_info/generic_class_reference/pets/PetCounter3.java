package books.onjava8.f19_type_info.generic_class_reference.pets;

import books.onjava8.f19_type_info.generic_class_reference.pets.pet.Pet;
import books.onjava8.f19_type_info.Pair;

import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * @author chenyuqun
 * @date 2021/5/18 6:26 下午
 */
public class PetCounter3 {
    static class Counter extends HashMap<Class<? extends Pet>, Integer> {
        Counter() {
            super(LiteralPetCreator.ALL_TYPES.stream()
                    .map(type -> Pair.make(type, 0))
                    .collect(
                            Collectors.toMap(Pair::key, Pair::value)));
        }

        public void count(Pet pet) {
            entrySet().stream().filter(pair -> pair.getKey().isInstance(pet)).forEach(pair -> put(pair.getKey(), pair.getValue() + 1));
        }

        @Override
        public String toString() {
            String re = "";
            for (Entry<Class<? extends Pet>, Integer> entry : entrySet()) {
                re += "[" + entry.getKey() + "]" + ":[" + entry.getValue() + "]\n";
            }
            return re;
        }

    }
    public static void main(String[] args) {
        Counter petCounter = new Counter();
        new LiteralPetCreator().stream().limit(20).peek(petCounter::count).forEach(p -> System.out.print(p.getClass().getSimpleName() + " "));
        System.out.println("\n" + petCounter);
    }

}
