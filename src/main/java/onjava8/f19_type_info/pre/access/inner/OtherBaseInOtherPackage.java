package onjava8.f19_type_info.pre.access.inner;

import com.google.common.collect.Lists;
import io.vavr.Tuple2;
import onjava8.f19_type_info.pre.access.Base;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author chenyuqun
 * @date 2021/5/25 8:43 下午
 */
public class OtherBaseInOtherPackage {
    public static void main(String[] args) {
        Base base = new Base();
        // 不在同一个包里，无法调用protected和default方法,下面两行都会报编译错误
//        base.defaultMethod();
//        base.protectedMethod();
        HashMap<Integer, Tuple2<Integer, Integer>> map = new HashMap<>();
        ArrayList<Object> collect = IntStream.range(0, 1001).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        Collections.shuffle(collect);
        for (int i = 1000; i > 0; i--) {
            map.put((Integer) collect.get(i), new Tuple2<>(i,i));
        }
        List<Integer> list1 = map.entrySet().stream().map(ele -> ele.getValue()._1).collect(Collectors.toList());
        List<Integer> list2 = map.entrySet().stream().map(ele -> ele.getValue()._2).collect(Collectors.toList());
        List<Integer> list3 = map.entrySet().stream().map(ele -> ele.getValue()._1).collect(Collectors.toList());
        List<Integer> list4 = map.entrySet().stream().map(ele -> ele.getValue()._2).collect(Collectors.toList());
        List<Integer> list5 = map.entrySet().stream().map(ele -> ele.getValue()._1).collect(Collectors.toList());
        List<Integer> list6 = map.entrySet().stream().map(ele -> ele.getValue()._2).collect(Collectors.toList());
        List<Integer> list7 = map.entrySet().stream().map(ele -> ele.getValue()._1).collect(Collectors.toList());
        List<Integer> list8 = map.entrySet().stream().map(ele -> ele.getValue()._2).collect(Collectors.toList());
        List<Integer> list9 = map.entrySet().stream().map(ele -> ele.getValue()._1).collect(Collectors.toList());
        List<Integer> list10 = map.entrySet().stream().map(ele -> ele.getValue()._2).collect(Collectors.toList());
        for (int i = 0; i < 1000; i++) {
            System.out.println(list1.get(i) +", "+
                    list2.get(i) + "," +
                    list3.get(i) + "," +
                    list4.get(i) + "," +
                    list5.get(i) + "," +
                    list6.get(i) + "," +
                    list7.get(i) + "," +
                    list8.get(i) + "," +
                    list9.get(i) + "," +
                    list10.get(i));
        }
    }
    @Test
    public void test2() {
        List<Object> list = Lists.newArrayList();
        list.add(1);
        list.add(2);
        Set<Integer> set = new HashSet<>();
        set.add(1); set.add(2); set.add(3);
        System.out.println(set.containsAll(list));
    }
}
