package books.onjava8.f19_type_info.class_info;

/**
 * @author chenyuqun
 * @date 2021/5/12 8:10 下午
 */
public class ToyTest {
    static void printInfo(Class cc, String desc) {
        System.out.println(desc);
        System.out.println("simpleName: " + cc.getSimpleName());
        System.out.println("name: " + cc.getName());
        System.out.println("interface: " + cc.isInterface());
        System.out.println("canonicalName: " + cc.getCanonicalName());
        System.out.println();
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("books.onjava8.f19_type_info.class_info.FancyToy");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 打印class信息
        printInfo(c, "FancyToy信息");
        // 打印interfaces信息
        for (Class anInterface : c.getInterfaces()) {
            printInfo(anInterface, "FancyToyDe接口");
        }
        // 打印superClass信息
        Class up = c.getSuperclass();
        printInfo(up, "FancyToy的superClass");
        Object obj = null;
        // 构造一个对象,使用 newInstance() 创建的对象，必须带有无参构造器
        try {
            obj = up.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        printInfo(obj.getClass(),"superClass创建出的对象");

        System.out.println(boolean.class == Boolean.TYPE);
    }
}
