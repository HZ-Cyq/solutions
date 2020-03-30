package compare;

import java.util.Comparator;

/**
 * @author playcrab_chenyuqun
 */
public class DescComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p2.getAge() - p1.getAge();
    }
}
