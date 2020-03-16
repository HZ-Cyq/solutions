package generics;

/**
 * @author playcrab_chenyuqun
 * 存储任意类型的容器
 */
public class ObjectContainer {
    private Object obj;

    public ObjectContainer(){}
    public ObjectContainer(Object obj) {
        this.obj = obj;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
