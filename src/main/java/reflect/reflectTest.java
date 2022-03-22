package reflect;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.*;
import java.util.Arrays;

/**
 * @author playcrab_chenyuqun
 */
public class reflectTest {

    /**
     * 1、获得class对
    * 2、通过class对象获得类名
     * 3、通过class对象获得类的修饰符：诸与public、private、static等
     * 4、通过class对象获得类所实现的接口类
     * 5、通过class对象获得类的方法
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
        for (Method method : methods) {
            System.out.println("MyObject method name: " + method.getName());
        }
        Method[] declaredMethods = myObjectClass1.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("declaredMethods method name: " + method.getName());
        }
        Class[] interfaces = myObjectClass1.getInterfaces();
        System.out.println("interfaces = " + Arrays.asList(interfaces));
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

    /**
     * https://blog.csdn.net/u014082714/article/details/50004843
     * 虚拟机只会产生一份字节码， 用这份字节码可以产生多个实例对象。
     * 在运行期间，如果我们要产生某个类的对象，Java虚拟机(JVM)会检查该类型的Class对象是否已被加载。如果没有被加载，JVM会根据类的名称找到.class文件并加载它。一旦某个类型的Class对象已被加载到内存，就可以用它来产生该类型的所有对象
     */
    @Test
    public void testGetClassEqual() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String str1 = "abc";
        Class class1 = str1.getClass();
        Class class2 = String.class;
        Class class3 = Class.forName("java.lang.String");
        Assert.assertTrue(class1 == class2 && class2 == class3);
        String str2 = (String) class1.newInstance();
        System.out.println("str2: " + str2);
    }

    /**
     * 测试Class.isAssignableFrom方法：基类可以assignableFrom子类。
     *
     * @throws ClassNotFoundException
     */
    @Test
    public void testIsAssignedFrom() throws ClassNotFoundException {
        Class myObjectCla = Class.forName("reflect.MyObject");
        Class interfaceCla = Class.forName("reflect.MyObjectsInterface");
        Class baseCla = Class.forName("reflect.MyObjectBase");

        Assert.assertFalse(myObjectCla.isAssignableFrom(interfaceCla));
        Assert.assertFalse(myObjectCla.isAssignableFrom(baseCla));

        Assert.assertTrue(myObjectCla.isAssignableFrom(myObjectCla));
        Assert.assertTrue(interfaceCla.isAssignableFrom(myObjectCla));
        Assert.assertTrue(baseCla.isAssignableFrom(myObjectCla));
    }

    /**
     * 测试Class.isInstance方法:
     */
    @Test
    public void testIsInstance() throws ClassNotFoundException {
        Class myObjectCla = Class.forName("reflect.MyObject");
        Class myObjectBaseCla = Class.forName("reflect.MyObjectBase");
        MyObject myObject = new MyObject();
        MyObjectBase myObjectBase = new MyObjectBase();

        Assert.assertTrue(myObjectCla.isInstance(myObject));
        Assert.assertFalse(myObjectCla.isInstance(myObjectBase));

        Assert.assertTrue(myObjectBaseCla.isInstance(myObjectBase));
        Assert.assertTrue(myObjectBaseCla.isInstance(myObject));
    }

    /**
     * 测试Class.isPrimitive方法
     *
     * @throws ClassNotFoundException
     */
    @Test
    public void testIsPrimitive() throws ClassNotFoundException {
        Assert.assertTrue(Integer.TYPE.isPrimitive());
        Assert.assertTrue(Short.TYPE.isPrimitive());
        Assert.assertTrue(Byte.TYPE.isPrimitive());
        Assert.assertTrue(Long.TYPE.isPrimitive());
        Assert.assertTrue(Float.TYPE.isPrimitive());
        Assert.assertTrue(Double.TYPE.isPrimitive());
        Assert.assertTrue(Boolean.TYPE.isPrimitive());
        Assert.assertTrue(Character.TYPE.isPrimitive());
        Assert.assertTrue(Void.TYPE.isPrimitive());

        Class myObjectCla = Class.forName("reflect.MyObject");
        Assert.assertTrue(myObjectCla.isSynthetic());
    }

    /**
     * 测试isSynthetic方法
     */
    @Test
    public void testIsSynthetic() {
        Assert.assertFalse(Proxy.newProxyInstance(Runnable.class.getClassLoader(), new Class[]{Runnable.class}, (proxy, method, args1) -> null).getClass().isSynthetic());
        MyObject myObject = new MyObject();
        Assert.assertFalse(myObject.getClass().isSynthetic());
        Assert.assertFalse(Integer.class.isSynthetic());

        Assert.assertTrue(((Runnable) System.out::println).getClass().isSynthetic());
        Assert.assertTrue(((Runnable) () -> {}).getClass().isSynthetic());
    }


    /**
     * 测试Class.toString方法
     */
    @Test
    public void testToString() throws ClassNotFoundException {
        Class myObjectCla = Class.forName("reflect.MyObject");
        System.out.println(myObjectCla.toString());
    }

    /**
     * 根据属性名获得属性值
     */
    @Test
    public void testAttribute() throws NoSuchFieldException, IllegalAccessException {
        Class cla = MyObject.class;
        Field attribute1Field = cla.getDeclaredField("attribute1");
        MyObject myObject = new MyObject();
        myObject.attribute1 = "hello, world";
        Object o = attribute1Field.get(myObject);
        Assert.assertEquals(myObject.attribute1, o.toString());
    }
}
