package design_pattern.structural.bridge;

import design_pattern.structural.bridge.Rule;

/**
 * @author chenyuqun
 */
public class AlertRule {
    Rule rule = new Rule(3,3);
    public Rule getMatchedRule(String api) {
        return rule;
    }
}
