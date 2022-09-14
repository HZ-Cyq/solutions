package mobinusi.handler;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface HandlerMethodAnnotation {
    int methodCode();

    String desc() default "";
}
