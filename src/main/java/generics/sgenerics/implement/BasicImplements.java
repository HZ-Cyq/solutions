package generics.sgenerics.implement;

/**
 * 基础的实现
 * @author playcrab_chenyuqun
 */
public class BasicImplements<T> implements GenericInterface<T>{
    T data;
    @Override
    public void setData(T data) {
        this.data = data;
    }

    @Override
    public T getData() {
        return data;
    }
}
