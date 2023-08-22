package books.onjava8.f19_type_info.generic_class_reference.pets;

import books.onjava8.f19_type_info.generic_class_reference.pets.pet.Pet;

/**
 * @author chenyuqun
 * @date 2021/5/19 11:46 上午
 */
public class PetCounter4 {
    public static void main(String[] args) {
        TypeCounter typeCounter = new TypeCounter(Pet.class);
        new LiteralPetCreator().stream().limit(20).peek(typeCounter::count).forEach(obj -> System.out.print(obj.getClass().getSimpleName() + " "));
        System.out.println(typeCounter);
    }
}
