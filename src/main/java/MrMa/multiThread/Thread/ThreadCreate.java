package MrMa.multiThread.Thread;

public class ThreadCreate {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("hello world"));
        thread.start();
    }
}
