package generics.sgenerics.method;

/**
 * @author playcrab_chenyuqun
 */
public class GenericMethod {

    public static <T> T add(T t1, T t2) {
        System.out.println("in add method: " + t1 + " " + t2);
        return t1;
    }

    public static <T1, T2> void printDifferentClass(T1 t1, T2 t2) {
        System.out.println("in method printDifferentClass: " + t1 + " "+ t2);
    }

}
