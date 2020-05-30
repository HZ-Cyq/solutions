package c;

/**
 * @author playcrab_chenyuqun
 */
public class CalSum {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            // 在c语言里是可以的，但是在java里不行。因为java里的bool值是一个基本的数据类型，而c里没有bool值，会把bool值转成int【0或1】。
//            sum += i * (i % 3 == 0 || i % 5 == 0);
        }
        System.out.printf("%d\n", sum);
    }
}
