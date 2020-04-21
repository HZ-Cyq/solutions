package generics.sgenerics.getType;

import java.lang.reflect.Type;

/**
 * @author playcrab_chenyuqun
 */
public interface ParameterizedType extends Type {
    // 返回确切的泛型参数, 如Map<String, Integer>返回[String, Integer]
    Type[] getActualTypeArguments();

    //返回当前class或interface声明的类型, 如List<?>返回List
    Type getRawType();

    //返回所属类型. 如,当前类型为O<T>.I<S>, 则返回O<T>. 顶级类型将返回null
    Type getOwnerType();
}
