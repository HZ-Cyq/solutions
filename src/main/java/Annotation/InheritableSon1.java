package Annotation;

/**
 * @author playcrab_chenyuqun
 * 测试Inherited注解：注解类加了这个注解，若父类被该注解类注解，子类也会被这个注解类注解
 */

import java.lang.annotation.*;

/**
 * 自定义的Annotation。
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
//@Inherited
@interface Inheritable
{
}

@Inheritable
class InheritableFather
{
    public InheritableFather() {
        // InheritableBase是否具有 Inheritable Annotation
        System.out.println("InheritableFather:"+InheritableFather.class.isAnnotationPresent(Inheritable.class));
    }
}

/**
 * InheritableSon 类只是继承于 InheritableFather，
 */
public class InheritableSon1 extends InheritableFather
{
    public InheritableSon1(){
        super();    // 调用父类的构造函数
        // InheritableSon类是否具有 Inheritable Annotation
        System.out.println("InheritableSon:"+InheritableSon1.class.isAnnotationPresent(Inheritable.class));
    }

    public static void main(String[] args)
    {
        InheritableSon1 is = new InheritableSon1();
    }
}
