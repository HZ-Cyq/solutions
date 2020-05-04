package designpattern.behavioral.strategy;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 通过注解创建策略类。
 * @author playcrab_chenyuqun
 */
public class StrategyFactoryWithAnnotation {
    Map<String, Strategy> map = Maps.newHashMap();
    static {
        //1、获得包下的所有类
        //2、将有StrategyAnnotation注解的类创建出来，放进map里
    }
}
