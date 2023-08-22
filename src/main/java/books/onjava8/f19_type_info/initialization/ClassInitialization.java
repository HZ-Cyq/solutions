package books.onjava8.f19_type_info.initialization;

/**
 * @author chenyuqun
 * @date 2021/5/13 2:59 下午
 */
public class ClassInitialization {

    public static void main(String[] args) throws ClassNotFoundException {
        // 1、非常量的static字段，触发了初始化
        System.out.println("staticNonFinal begin");
        use(Initable.staticNonFinal);
        System.out.println("staticNonFinal end\n");
        // 2、编译期常量，不会触发初始化
        System.out.println("staticFinalCompile begin");
        use(Initable2.STATIC_FINAL);
        System.out.println("staticFinalCompile end\n");
        // 3、运行期常量，触发了初始化
        System.out.println("staticFinalRunning begin");
        use(Initable2.STATIC_FINAL2);
        System.out.println("staticFinalRunning end\n");
        // 4、.class 没有触发初始化
        System.out.println(".class begin");
        use(Initable3.class);
        System.out.println(".class end\n");
        // 5、forName() 触发了初始化
        System.out.println("forName begin");
        Class initable3 = Class.forName("books.onjava8.f19_type_info.initialization.Initable3");
        use(initable3);
        System.out.println("forName end\n");
    }

    public static void use(Object obj) {
        return;
    }

}
