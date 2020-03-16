package generics.targettypeinference;

import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author playcrab_chenyuqun
 * 根据方法的参数类型推断泛型
 */
public class TestInference {
    public <T> T pick(T a1, T a2) {
        return a1;
    }

    @Test
    public void testPick() {
        Serializable s = pick("d", new ArrayList<String>());
        System.out.println(pick("d", new ArrayList<String>()));
    }

    @Test
    public void testBox() {
        ArrayList<Box<Integer>> listOfIntegerBoxes = new ArrayList<>();

        BoxDemo.<Integer>addBox(Integer.valueOf(10), listOfIntegerBoxes); // 不需要再这样了
        BoxDemo.addBox(Integer.valueOf(20), listOfIntegerBoxes);
        BoxDemo.addBox(Integer.valueOf(30), listOfIntegerBoxes);
        BoxDemo.outputBoxes(listOfIntegerBoxes);

        BoxDemo.addBox(Integer.valueOf(40));
    }
    @Test
    public void testList() {
        // 可以通过nil方法的返回值推出Z是String类型。
        List.cons(List.nil());
    }
}
