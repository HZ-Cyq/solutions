package books.onjava8.f19_type_info.generic_class_reference.pets;

/**
 * @author chenyuqun
 * @date 2021/5/18 6:22 下午
 */
public class PetCounter2 {
    public static void main(String[] args) {
        new PetCounter().count(new LiteralPetCreator());
    }
}
