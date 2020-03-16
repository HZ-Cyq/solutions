package generics;

/**
 * @author playcrab_chenyuqun
 */
public class GenericContainer<T> {
    private T obj;

    public GenericContainer(){
        System.out.println("GenericContainer 无参构造方法");
    }
    public GenericContainer(T obj) {
        this.obj = obj;
    }
    public GenericContainer(Integer value) {
        Integer v = value + 1;
        this.obj = (T)(v);
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
