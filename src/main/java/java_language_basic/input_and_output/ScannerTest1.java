package java_language_basic.input_and_output;

import java.util.Scanner;

/**
 * @author playcrab_chenyuqun
 */
public class ScannerTest1 {
    public static void main(String args[]) {
        System.out.println("请输入若干个数据，每输入一个数据用回车确认");
        System.out.println("最后输入一个非数字结束操作");

        Scanner reader = new Scanner(System.in);
        double sum = 0;
        int m = 0;
        while (reader.hasNextDouble()) {
            double x = reader.nextDouble();
            m = m + 1;
            sum = sum + x;
        }
        System.out.printf("%d 个数的和为 %f\n", m, sum);
        System.out.printf("%d 个数的平均值为 %f\n",m, sum / m);
    }
}
