package generics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author playcrab_chenyuqun
 */
public class GenericsTest {
    /**
     * 测试ObjectContainer
     */
    @Test
    public void testObjectContainer() {
        ObjectContainer myObj1 = new ObjectContainer();
        myObj1.setObj("Test");
        System.out.println(myObj1.getObj());

        ObjectContainer myObj2 = new ObjectContainer();
        myObj2.setObj(3);
        System.out.println(myObj2.getObj());


        List<ObjectContainer> objList = new ArrayList();
        objList.add(myObj1);
        objList.add(myObj2);
        String myStr = (String) (objList.get(0)).getObj();
        Integer myInteger = (Integer)(objList.get(1)).getObj();
        System.out.println("myString:" + myStr);
        System.out.println("myInteger:" + myInteger);
    }

    /**
     * 测试泛型类GenericContainer.
     */
    @Test
    public void testGenericContainer() {
        GenericContainer<Integer> myInt = new GenericContainer<Integer>();
        myInt.setObj(3);
        System.out.println(myInt.getObj());// 可以编译
        // myInt.setObj("hello"); // 不可编译
    }

    /**
     * 测试ObjectContainer和GenericContainer
     */
    @Test
    public void test() {
        List objectList = new ArrayList();
        for(int i = 0; i < 10; i++) {
            ObjectContainer obj = new ObjectContainer("obj" + i);
            objectList.add(obj);
        }
        for (int i = 0; i < 10; i++) {
            String myStr = (String) ((ObjectContainer)objectList.get(i)).getObj();
            System.out.println(myStr);
        }

        List<GenericContainer>  genericContainerList = new ArrayList();
        for(int i = 0; i < 10; i++) {
            GenericContainer obj = new GenericContainer<>("generic" + i);
            genericContainerList.add(obj);
        }
        for(int i = 0; i < 10; i++) {
            GenericContainer<String> obj = new GenericContainer<>(i);
            //GenericContainer<Integer> obj = new GenericContainer<Integer>(i); //这样写编译错误，相当于有两个传入参数是Integer的构造函数。
            genericContainerList.add(obj);
        }
        for(int i = 0; i < 20; i++) {
            GenericContainer obj = genericContainerList.get(i);
            System.out.println(obj.getObj());
        }
    }

    /**
     * JEP 101: Generalized Target-Type Inference
     */
    @Test
    public void testInference() {
        List<String> list = new ArrayList<>();
        list.add("A");// 由于addAll期望获得Collection<? extends String>类型的参数，因此下面的语句无法通过
        list.addAll(new ArrayList<>());
        list.forEach(obj -> System.out.println(obj));
    }
}
