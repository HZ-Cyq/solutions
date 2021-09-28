package test.mock;

import com.google.common.collect.Maps;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Map;

/**
 * @author chenyuqun
 * @date 2021/1/8 4:50 下午
 */
@PrepareForTest({ClassA.class})
@RunWith(PowerMockRunner.class)
public class PowerMockTest {
    @BeforeClass
    public static void beforeClass() {
        PowerMockito.mockStatic(ClassA.class);
        //when(ClassA.getOne()).thenReturn(2);
    }

    @Test
    public void test1() {
        System.out.println("test1: " + ClassA.getOne());
    }

    @Test
    public void test2() {
        System.out.println("test2: " + ClassA.getOne());
    }

    @Test
    public void test3() {
        Map<String, Integer> map = Maps.newHashMap();
        map.put("1", 1);
        Integer remove = map.remove("0");
        System.out.println(remove);
    }

    @Test
    public void test4() throws CloneNotSupportedException {
        ClassA classA = new ClassA();
        classA.a = 1;
        classA.str = "str";

        ClassA clone = (ClassA) classA.clone();
        clone.a = 2;
        System.out.println(classA.a);
    }

}
