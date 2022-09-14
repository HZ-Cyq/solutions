package reflect.java_compile;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class Test {
    public static void main(String[] args) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int testJavaCompiler = compiler.run(null, null, null, "TestJavaCompiler.java");
        System.out.println(testJavaCompiler);
    }
}
