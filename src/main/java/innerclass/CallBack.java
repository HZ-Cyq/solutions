package innerclass;

/**
 * @author playcrab_chenyuqun
 * java的回调：基于匿名内部类实现
 */
public class CallBack {

    public static void main(String[] args) {
        CallBack callBack = new CallBack();
        callBack.toDoSomethings(1000, new CallBackInterface() {
            public void execute() {
                System.out.println("我的请求处理成功了");
            }
        });
    }

    public void toDoSomethings(int a, CallBackInterface callBackInterface) {
        long start = System.currentTimeMillis();
        if (a > 100) {
            callBackInterface.execute();
        } else {
            System.out.println("a < 100 不需要执行回调方法");
        }
        long end = System.currentTimeMillis();
        System.out.println("该接口回调时间 : " + (end - start));
    }
}
