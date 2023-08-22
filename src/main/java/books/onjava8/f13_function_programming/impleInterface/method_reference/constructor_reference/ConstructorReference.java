package books.onjava8.f13_function_programming.impleInterface.method_reference.constructor_reference;

/**
 * @author chenyuqun
 * @date 2021/5/28 4:09 下午
 */
public class ConstructorReference {
    static class Dog {
        int age;
        String name;

        public Dog() {
        }

        public Dog(String name) {
            this.name = name;
        }

        public Dog(String name, int age) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Dog{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    interface MakeDogZeroArg {
        Dog makeDog();
    }

    interface MakeDogOneArg {
        Dog makeDog(String name);
    }

    interface MakeDogTwoArgs {
        Dog makeDog(String name, int age);
    }

    public static void main(String[] args) {
        MakeDogZeroArg makeDogZeroArg = Dog::new;
        MakeDogOneArg makeDogOneArg = Dog::new;
        MakeDogTwoArgs makeDogTwoArgs = Dog::new;

        System.out.println(makeDogZeroArg.makeDog());
        System.out.println(makeDogOneArg.makeDog("Alice"));
        System.out.println(makeDogTwoArgs.makeDog("Bob", 4));
    }
}
