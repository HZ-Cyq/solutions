package designpattern.behavioral.strategy;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author playcrab_chenyuqun
 */
public enum StrategyType {
    CONCRETE_STRATEGY_A("A",ConcreteStrategyA.class),

    CONCRETE_STRATEGY_B("B", ConcreteStrategyB.class);

    public String type;

    public Class<? extends Strategy> cla;

    StrategyType(String type, Class cla) {
        this.type = type;
        this.cla = cla;
    }

    private static Map<String, StrategyType> map = Maps.newHashMap();

    static {
        for(StrategyType strategyType: StrategyType.values()) {
            map.put(strategyType.type, strategyType);
        }
    }

    public static StrategyType getStrategyType(String type) {
        return map.get(type);
    }

    public Strategy newInstance() {
        try {
            return cla.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Class getCla() {
        return cla;
    }

    public void setCla(Class cla) {
        this.cla = cla;
    }
}

