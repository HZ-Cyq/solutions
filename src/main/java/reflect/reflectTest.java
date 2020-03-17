package reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author playcrab_chenyuqun
 */
public class reflectTest {

    /**
     * 1、获得class对象
     * 2、通过class对象获得类名
     * 3、通过class对象获得类的修饰符：诸与public、private、static等
     * 4、通过class对象获得类的方法
     */
    @Test
    public void testGetClass() {
        Class myObjectClass1 = MyObject.class;
        try {
            Class myObjectClass2 = Class.forName("reflect.MyObject");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String className = myObjectClass1.getName();
        String classSimpleName = myObjectClass1.getSimpleName();
        System.out.println("class name: " + className);
        System.out.println("class simple name: " + classSimpleName);

        int modifier = myObjectClass1.getModifiers();
        System.out.println("class modifier: " + Modifier.toString(modifier));

        Method[] methods = myObjectClass1.getMethods();
        for(Method method : methods) {
            System.out.println("MyObject method name: " + method.getName());
        }
        Method[] declaredMethods = myObjectClass1.getDeclaredMethods();
        for(Method method : methods) {
            System.out.println("declaredMethods method name: " + method.getName());
        }

    }


    /**
     * 利用Construct对象实例化一个类
     */
    @Test
    public void testCreateObject() {
        Class parameterType = String.class;
        Constructor constructor;
        MyObject myObject;
        try {
            constructor = MyObject.class.getConstructor(parameterType);
            myObject = (MyObject) constructor.newInstance("hello");
            System.out.println(myObject.getAttribute1());
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
