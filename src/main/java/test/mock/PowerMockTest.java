package test.mock;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

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
}
