package books.code_out_efficiency.B05_02_try_catch_finally;

/**
 * 在catch里面有return，先执行finally里的代码，return会暂存，finally执行完了再执行return
 * 在catch里面有System.exit(), 就不会执行finally里的代码了。
 *
 * @author chenyuqun
 * @date 2022/2/23 4:13 下午
 */
public class FinallyTest1 {
    public static void main(String[] args) {
        // 这行代码会输出 finally in method1
        int i = method1();
        // 这行代码不会输出 finally in method2
        int j = method2();
        System.out.println(i + j);
    }

    public static int method1() {
        try {
            System.out.println("try in method1");
            return 1;
        } finally {
            System.out.println("finally in method1");
        }
    }

    public static int method2() {
        try {
            System.out.println("try in method2");
            System.exit(1);
            return 1;
        } finally {
            System.out.println("finally in method2");
        }
    }
}
