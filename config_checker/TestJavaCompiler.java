package config2;
import config1.*;

public class TestJavaCompiler {
    public TestJavaCompiler() {
    }

    public static void main(String[] var0) {
        System.out.println("TestCompiler main");
    }

    public void method1() {
        System.out.println("hello world");
    }

    public void method2() {
        ModelConfig modelConfig = new ModelConfig();
        modelConfig.method1();
    }
}
