package generics;

import java.lang.reflect.ParameterizedType;

abstract class Foo<T> {
    public Class<T> getTClass() {
        Class<T> tClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return tClass;
    }
}
