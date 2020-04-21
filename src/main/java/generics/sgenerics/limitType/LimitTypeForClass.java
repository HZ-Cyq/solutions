package generics.sgenerics.limitType;

import java.util.List;

/**
 * 限定泛型类的类型
 * @author playcrab_chenyuqun
 */
public class LimitTypeForClass<T extends List> {
    T data;

    public LimitTypeForClass(T data) {
        this.data = data;
    }

    /**
     * 返回data的长度
     * @param
     * @return
     */
    public int getSize() {
        return data.size();
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
