package onjava8.f14_stream;

import java.util.stream.IntStream;

/**
 * @author chenyuqun
 * @date 2021/6/15 9:03 下午
 */
public class Ranges {
    /**
     * 计算10，11，12...19的和
     * @param args
     */
    public static void main(String[] args) {
        int result = 0;
        // 传统的方法
        for (int i = 10; i < 20; i++) {
            result += i;
        }
        System.out.println(result);
        result = 0;
        // for-in 循环
        for(int i : IntStream.range(10, 20).toArray()) {
            result += i;
        }
        // 使用流
        System.out.println(result);
        result = IntStream.range(10,20).sum();
        System.out.println(result);
    }
}
