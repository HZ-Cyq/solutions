package generics.sgenerics.classes;

/**
 * @author playcrab_chenyuqun
 */
public class GenericClass<T> {
    T data;

    public GenericClass() {

    }

    public GenericClass(T data) {
        this.data = data;
    }

    public void print(T t) {
        System.out.println(t);
    }

    public <T> void printT(T t) {
        System.out.println(t);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
