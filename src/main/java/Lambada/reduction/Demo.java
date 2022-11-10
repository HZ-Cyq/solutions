package Lambada.reduction;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.regex.Pattern;

public class Demo {
    public static void main(String[] args) {
        List<Person> roster = Lists.newArrayList();
        roster.add(new Person());
        roster.add(new Person());
        roster.add(new Person());
        // FIXME combine好像只有parallelStream的时候才会调用
        Averager averageCollect = roster.parallelStream()
                .map(Person::getAge)
                .collect(Averager::new, Averager::accept, Averager::combine);
        System.out.println("Average age of male members: " +
                averageCollect.average());
        // 这个和上面的效果是一样的
//        roster.stream().map(Person::getAge).collect(Averager::new,
//                (average, ele) -> average.accept(ele),
//                (average1, average2) -> average1.combine(average1));
    }
}
