package onjava8.f19_type_info.generic_class_reference.pets;

import java.util.HashMap;

/**
 * @author chenyuqun
 * @date 2021/5/19 11:33 上午
 */
public class TypeCounter extends HashMap<Class<?>, Integer> {
    private Class<?> baseType;

    public TypeCounter(Class<?> baseType) {
        this.baseType = baseType;
    }

    public void count(Object obj) {
        Class<?> aClass = obj.getClass();
        if (!baseType.isAssignableFrom(aClass)) {
            throw new RuntimeException("baseType is not aClass superClass or super interface, baseType: " + baseType + "aClass: " + aClass);
        }
        countClass(obj.getClass());
    }

    private void countClass(Class<?> type) {
        Integer quantity = get(type);
        put(type, quantity == null ? 1 : quantity + 1);
        Class<?> superClass = type.getSuperclass();
        if (superClass != null && baseType.isAssignableFrom(superClass))
            countClass(superClass);
    }

    @Override
    public String toString() {
        String re = "\n";
        for (Entry<Class<?>, Integer> entry : entrySet()) {
            re += "[" + entry.getKey().getSimpleName() + "]:[" + entry.getValue() + "]\n";
        }
        return re;
    }
}
