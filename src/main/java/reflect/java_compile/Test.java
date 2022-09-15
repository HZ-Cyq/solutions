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
        // 如果直接在terminal中调用 javac config/*.java 可以编译成功
        // 但是在这里却失败, 所以是手动的添加需要加载的类。顺序无关。
        // package: 用来指定生成的class文件路径。在执行javac命令进行编译的时候
        //   如果没有设置-d参数，生成的class文件在源文件所在的路径下，
        //   如果设置了-d参数，生成的class文件在 -d指定的路径 + 包名的路径下
        // -d:生成的class文件路径
        int testJavaCompiler = compiler.run(null, null, null,
                "-d", "config_checker/class",
                "config_checker/ModelConfig.java", "config_checker/TestJavaCompiler.java");
        System.out.println(testJavaCompiler);
        // LOOKOUT 这里最后一个字符是"/"，如果没有这个斜杠，下面loadClass的时候会报ClassNotFind的错误
        URL url = new URL("file:///Users/mac/chenyuqun/solutions/config_checker/class/");
        URLClassLoader urlClassLoader = URLClassLoader.newInstance(new URL[]{url});
        Class<?> testJavaCompiler2 = urlClassLoader.loadClass("config2.TestJavaCompiler");
        Object o = testJavaCompiler2.newInstance();
        Method method1 = o.getClass().getDeclaredMethod("method2");
        method1.invoke(o);
    }
}
