package generics.sgenerics.implement;

/**
 * 在给数据赋值、获取值的时候会打印值
 * @author playcrab_chenyuqun
 */
public class PrintImplements<T> implements GenericInterface<T>{
    T data;
    @Override
    public void setData(T data) {
        System.out.println("setData: " + data);
        this.data = data;
    }

    @Override
    public T getData() {
        System.out.println("getData: " + data);
        return data;
    }
}
