package design_pattern.behavioral.strategy;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 策略工厂
 *
 * @author playcrab_chenyuqun
 */
public class StrategyFactory {
    private static Map<String, Strategy> strategyMap = Maps.newHashMap();

    static {
        strategyMap.put("A", new ConcreteStrategyA());
        strategyMap.put("B", new ConcreteStrategyB());
    }

    /**
     * 获得存在表里的策略对象
     * @param type
     * @return
     */
    public static Strategy getStrategy(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type should not be empty");
        }
        return strategyMap.get(type);
    }

    /**
     * 获得新的策略对象，需要有if,else判断。
     * @param type
     * @return
     */
    public static Strategy getNewStrategyWithIfElse(String type) {
        if(type.equals("A")) {
            return new ConcreteStrategyA();
        }  else if(type.equals("B")) {
            return new ConcreteStrategyB();
        }
        return null;
    }

    /**
     * 创建新的策略对象，通过enum，不用If、else
     * @param type
     * @return
     */
    public static Strategy getNewStrategy(String  type) {
        StrategyType strategyType = StrategyType.getStrategyType(type);
        return strategyType.newInstance();
    }
}
