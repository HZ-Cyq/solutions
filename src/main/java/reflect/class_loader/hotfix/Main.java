package reflect.class_loader.hotfix;

import cn.hutool.core.io.FileUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InterruptedException, ClassNotFoundException,
            IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        int a = 1;
        while (true) {
            FileClassLoader fileClassLoader = new FileClassLoader();
            fileClassLoader.setFileName("/Users/mac/chenyuqun/solutions/target/classes/reflect/class_loader/hotfix/SayHello.class");
            Object obj = null;
            obj = fileClassLoader.loadClass("reflect.class_loader.hotfix.SayHello").newInstance();
            Method m = obj.getClass().getMethod("say", new Class[]{});
            m.invoke(obj, new Object[]{});
            Thread.sleep(2000);
        }
    }
}