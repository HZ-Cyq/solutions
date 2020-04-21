package generics.sgenerics;

import generics.sgenerics.classes.GenericClass;
import generics.sgenerics.getType.GenericType;
import generics.sgenerics.implement.BasicImplements;
import generics.sgenerics.implement.GenericInterface;
import generics.sgenerics.implement.PrintImplements;
import generics.sgenerics.limitType.LimitTypeFoMethod;
import generics.sgenerics.limitType.LimitTypeForClass;
import generics.sgenerics.method.GenericMethod;
import generics.sgenerics.wildCard.Apple;
import generics.sgenerics.wildCard.Food;
import generics.sgenerics.wildCard.Fruit;
import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

/**
 * @author playcrab_chenyuqun
 */
public class GenericTest {

    @Test
    public void test1() {
        List list = new ArrayList();
        list.add("A");
        list.add("B");
//        list.add(new C());
        list.add(100);
        //1.当我们将一个对象放入集合中，集合不会记住此对象的类型，当再次从集合中取出此对象时，改对象的编译类型变成了Object类型，但其运行时类型任然为其本身类型。
        //2.因此，//1处取出集合元素时需要人为的强制类型转化到具体的目标类型，且很容易出现“java.lang.ClassCastException”异常。
        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
            String value = (String) list.get(i);
            System.out.println(value);
        }
    }

    /**
     * 测试泛型接口:泛型的实现方式
     */
    @Test
    public void test2() {
        GenericInterface<String> basic = new BasicImplements<>();
        basic.setData("basic hello");
        System.out.println("print data in test: " + basic.getData());
        GenericInterface<String> print = new PrintImplements<>();
        print.setData("print hello");
        System.out.println("print data in test: " + print.getData());


        GenericInterface<Integer> basic1 = new BasicImplements<>();
        basic1.setData(2);
        System.out.println("print data in test: " + basic1.getData());
        GenericInterface<Integer> print1 = new PrintImplements<>();
        print1.setData(3);
        System.out.println("print data in test: " + print1.getData());
    }

    /**
     * 测试泛型方法
     */
    @Test
    public void test3() {
        String re = GenericMethod.add("hello", "world");
        System.out.println(re);

        Integer re1 = GenericMethod.add(1, 2);
        System.out.println(re1);

        GenericMethod.printDifferentClass("hello", "world");
        GenericMethod.printDifferentClass("hello", 1);
    }

    /**
     * 测试泛型类
     */
    @Test
    public void test4() {
        GenericClass<String> genericClass = new GenericClass<>();
        genericClass.print("hello");
        genericClass.printT(1);
    }

    /**
     * 测试限制类型
     */
    @Test
    public void test5() {
        // 测试限定类的泛型方法
        System.out.println(LimitTypeFoMethod.getMin(1,2));
        System.out.println(LimitTypeFoMethod.getMin('a','c'));

        // 测试限定类型的泛型类
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        LimitTypeForClass<ArrayList> al = new LimitTypeForClass<>(arrayList);

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        LimitTypeForClass<LinkedList> ll = new LimitTypeForClass<>(linkedList);

        System.out.println(LimitTypeFoMethod.getMin(al.getData().size(), ll.getData().size()));
    }

    /**
     * 测试通配符
     */
    @Test
    public void test6() {
        // 1、在方法中的通配符。
        Fruit fruit = new Fruit("green");
        GenericClass<Fruit> genericClass = new GenericClass<>(fruit);
        printExtends(genericClass);
        Apple apple = new Apple("red");
        GenericClass<Apple> genericClass1 = new GenericClass<>(apple);
        printExtends(genericClass1);

        // 2、在类里的通配符
        // 2.1 extends:不能set,只能get
        GenericClass<? extends Fruit> genericClass2 = new GenericClass<>();
        // 不可以setData,因为不知道?代表哪个具体的子类，无法设置
        // genericClass2.setData(fruit);
        // 可以getData，因为知道一定是Fruit或者Fruit的子类。
       System.out.println(genericClass2.getData());

       // 2.2 super:能set也能get
       GenericClass<? super Fruit> genericClass3 = new GenericClass<>();
       // 可以setData也可以getColor但是不能继续getColor:
        Food food = new Food();
       genericClass3.setData(fruit);
       genericClass3.setData(apple);
       System.out.println(genericClass3.getData());

       // 2.3 没有:不能set,只能get
        GenericClass<?> genericClass4 = new GenericClass<>();
        // 不能set,只能get,返回值可以用Object。
        // genericClass4.setData(fruit);
        // genericClass4.setData(apple);
        Object obj = genericClass4.getData();
        System.out.println(obj);
    }

    private void printExtends(GenericClass<? extends Fruit> genericClass) {
        System.out.println(genericClass.getData().getColor());
    }

    /**
     * 测试获得泛型的参数类型
     */
    @Test
    public void test7() {
        GenericType<String> genericType = new GenericType<String>() {};
        Type superclass = genericType.getClass().getGenericSuperclass();
        //getActualTypeArguments 返回确切的泛型参数, 如Map<String, Integer>返回[String, Integer]
        // ParameterizedType是java.lang.reflect里的,不是自己写的，为什么自己写的会报这个错呢？
        // java.lang.ClassCastException: sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl cannot be cast to generics.sgenerics.getType.ParameterizedType
        ParameterizedType type1 = (ParameterizedType)superclass;
        Type type = type1.getActualTypeArguments()[0];
        System.out.println(type);//class java.lang.String
    }

    /**
     * 测试泛型的实现原理:在genericTheory.GenericTheory里
     */
    @Test
    public void test8() {
    }
}
