package reflect.class_loader;

/**
 * @author chenyuqun
 * @date 2022/1/22 11:00 上午
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        SimpleClassLoader simpleClassLoader = new SimpleClassLoader();
        Class<?> aClass = simpleClassLoader.loadClass("reflect.class_loader.111");
        System.out.println(aClass);
    }
}
