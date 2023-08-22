package books.onjava8.f19_type_info.generic_class_reference.pets;

import books.onjava8.f19_type_info.generic_class_reference.pets.pet.Pet;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author chenyuqun
 * @date 2021/5/18 3:45 下午
 */
public abstract class Creator implements Supplier<Pet> {
    private Random random = new Random(47);

    public abstract List<Class<? extends Pet>> types();

    @Override
    public Pet get() {
        int index = random.nextInt(types().size());
        try {
            return types().get(index).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Stream<Pet> stream() {
        return Stream.generate(this);
    }

    public Pet[] array(int size) {
        return stream().limit(size).toArray(Pet[]::new);
    }

    public List<Pet> list(int size) {
        return stream().limit(size).collect(Collectors.toList());
    }
}
