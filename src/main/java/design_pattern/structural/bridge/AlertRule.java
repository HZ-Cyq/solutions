package design_pattern.structural.bridge;

/**
 * 这个类主要是根据api获得不同类型的Rule
 * @author chenyuqun
 */
public class AlertRule {
    Rule rule = new Rule(3, 3);

    /**
     * 根据api获取对应的Rule,Rule是个配置类。当数值超过rule值的时候会进行推送。
     *
     * @param api
     * @return
     */
    public Rule getMatchedRule(String api) {
        return rule;
    }
}
