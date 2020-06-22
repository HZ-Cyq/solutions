package compare;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author playcrab_chenyuqun
 */
public class Test1 {

    @Test
    public void testEquals() {
        String a = "123";
        String b = "123";
        String c = new String("123");

        Assert.assertTrue(a == b);
        Assert.assertFalse(a == c);
        Assert.assertTrue(a.equals(c));
        // "=="作用于引用：引用是否相等。与引用类型无关
        Object d = c;
        Assert.assertTrue(d == c);
    }

    @Test
    public void testComparable() {
        Person person1 = new Person("name_1",10);
        Person person2 = new Person("name_1",11);
        Person person3 = new Person("name_1",12);
        Person person4 = new Person("name_1",9);

        List<Person> list = new LinkedList<>();
        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);

        System.out.println("内部排序：");
        Collections.sort(list);
        list.stream().forEach(person -> System.out.println("name: " + person.getName() + ", age: "+ person.getAge()));

        System.out.println("外部排序：");
        Collections.sort(list, new DescComparator());
        list.stream().forEach(person -> System.out.println("name: " + person.getName() + ", age: "+ person.getAge()));
    }
}
