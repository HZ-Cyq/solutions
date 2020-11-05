package design_pattern.creational.factory;

/**
 * 简单工厂的第一种实现方法,使用if, else,如果创建逻辑简单，创建的类少，可以直接用这种实现
 *
 * @author chenyuqun
 */
public class RuleConfigParserFactory1 {
    public static IRuleConfigParser createParser(String configFormat) {
        IRuleConfigParser parser = null;
        if ("json".equalsIgnoreCase(configFormat)) {
            parser = new JsonRuleConfigParser();
        } else if ("xml".equalsIgnoreCase(configFormat)) {
            parser = new XmlRuleConfigParser();
        } else if ("yaml".equalsIgnoreCase(configFormat)) {
            parser = new YamlRuleConfigParser();
        }
        return parser;
    }
}
