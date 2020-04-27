package designpattern.behavioral.template;

import designpattern.behavioral.template.callBack.AClass;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author playcrab_chenyuqun
 */
public class templateTest extends TestCase {

    /**
     * setUp方法是在TestCase的runBare方法里的模板方法，在子类中实现。
     */
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

    /**
     * 测试回调方法
     */
    public void testCallBack() {
        AClass.method();
    }
}
