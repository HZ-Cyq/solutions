package reflect.java_compile;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, MalformedURLException {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int testJavaCompiler = compiler.run(null, null, null, "TestJavaCompiler.java");
        System.out.println(testJavaCompiler);
        URL url = new URL("file:///Users/mac/chenyuqun/solutions/");
        URLClassLoader urlClassLoader = URLClassLoader.newInstance(new URL[]{url});
        Class<?> testJavaCompiler2 = urlClassLoader.loadClass("TestJavaCompiler");
        Object o = testJavaCompiler2.newInstance();
        System.out.println(o.getClass());
        for (Method declaredMethod : o.getClass().getDeclaredMethods()) {
            System.out.println(declaredMethod.getName());
        }
    }
}
