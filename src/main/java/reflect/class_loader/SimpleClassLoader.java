package reflect.class_loader;

import java.io.IOException;
import java.io.InputStream;

/**
 * 实现一个简单的class classloader
 * @author chenyuqun
 * @date 2022/1/22 10:58 上午
 */
public class SimpleClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        InputStream map = Test.class.getResourceAsStream("Test.class");
        try {
            byte[] bytes = new byte[map.available()];
            map.read(bytes);
            return super.defineClass(Test.class.getName(), bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }
}
