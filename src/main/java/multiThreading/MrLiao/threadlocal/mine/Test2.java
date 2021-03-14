package multiThreading.MrLiao.wait_and_notify;

/**
 * 上下文实现AutoCloseable接口，利用try(resource){...}结构,在调用完之后会自动的删掉。
 *
 * @author chenyuqun
 * @date 2021/1/21 11:50 上午
 */
public class Test2 {
    public static void main(String[] args) {
        try(UserContext userContext = new UserContext("hello")) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class UserContext implements AutoCloseable {
    static final ThreadLocal<String> ctx = new ThreadLocal<>();

    public UserContext(String user) {
        ctx.set(user);
    }

    public static String currentUser() {
        return ctx.get();
    }

    @Override
    public void close() throws Exception {
        ctx.remove();
    }
}
