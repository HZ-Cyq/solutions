package designpattern.behavioral.template;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author playcrab_chenyuqun
 */
public class templateTest extends TestCase {

    @Override
    public void setUp() {
        System.out.println("before class :set up");
    }
    /**
     * 测试自己写的模板模式
     */
    @Test
    public void testTemplate() {
        AbstractClass abstractClass = new ConcreteClass1();
        abstractClass.templateMethod();

        AbstractClass abstractClass1 = new ConcreteClass2();
        abstractClass1.templateMethod();;
    }

    /**
     * list的addAll方法用了模板模式
     */
    public void test1() {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list1.addAll(list2);
        System.out.println("hello");
    }

}
