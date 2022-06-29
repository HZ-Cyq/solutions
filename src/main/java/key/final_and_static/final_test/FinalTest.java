package key.final_and_static.final_test;

/**
 * @author chenyuqun
 */
public class FinalTest {
    public void testFinal() {
        // 没有声明是final，a可以重新指向别的数组
        int[] a = {1, 2};
        a = new int[]{3, 4};
        // 声明了是final,b就不可以指向别的数组
        final int[] b = {1, 2};
        // 下面这句话会报错
        //b = new int[]{3,4};
    }

}
