package compare;

/**
 * @author playcrab_chenyuqun
 */
public class Person implements Comparable<Person> {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean equals(Person o) {
        return (this.name.equals(o.getName()) && this.age == o.getAge());
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.getAge();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
