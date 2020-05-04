package designpattern.behavioral.strategy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
public @interface StrategyAnnotation {
    String type = "";
    String type();
}
