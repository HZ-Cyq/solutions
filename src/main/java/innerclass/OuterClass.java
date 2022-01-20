package innerclass;

/**
 * @author chenyuqun
 * @date 2022/1/19 5:21 下午
 */
public class OuterClass {

    public static class StaticInnerClass {
    }


    public class InstanceClass {
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        });

        class methodClass1 {
            int a;
            int b;
        }
        class methodClass2 {
            int c;
            int d;
        }

    }
}
