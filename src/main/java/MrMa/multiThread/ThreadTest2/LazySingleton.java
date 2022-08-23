package MrMa.multiThread.ThreadTest2;

public class LazySingleton {

    private int id;

    private static class LazySingletonHolder {
        private static final LazySingleton instance = new LazySingleton();
    }

    private LazySingleton() {
    }

    private void setId(int id) {
        this.id = id;
    }

    private int getId() {
        return id;
    }

    public static LazySingleton getInstance() {
        return LazySingletonHolder.instance;
    }

    public static void main(String[] args) {
        LazySingleton.getInstance().setId(10);
        System.out.println(LazySingleton.getInstance().getId());
    }
}
