package design_pattern.creational.factory;

import design_pattern.creational.factory.factory_method.RuleConfigParserFactoryMap;
import design_pattern.creational.factory.other_realization.ShapeFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 简单工厂的第二种实现方法，如果创建出来的对象可以复用，就可以用这种方法实现
 * 如果不能复用，而且不想用if, else
 * 用工厂方法模式{@link RuleConfigParserFactoryMap#getParserFactory(String)}
 * 或在map里存Supplier，拿对象的时候调用supplier创建新对象，参考{@link ShapeFactory#getShape(String)}。【这种看起来更简单】
 *
 * @author chenyuqun
 */
public class RuleConfigParserFactory2 {
    private static final Map<String, IRuleConfigParser> cachedParsers = new HashMap<>();

    static {
        cachedParsers.put("json", new JsonRuleConfigParser());
        cachedParsers.put("xml", new XmlRuleConfigParser());
        cachedParsers.put("yaml", new YamlRuleConfigParser());
    }

    public static IRuleConfigParser createParser(String configFormat) {
        if (configFormat == null || configFormat.isEmpty()) {
            return null;
        }
        return cachedParsers.get(configFormat.toLowerCase());
    }

    public static void main(String[] args) {
        IRuleConfigParser parser1 = RuleConfigParserFactory2.createParser("json");
        IRuleConfigParser parser2 = RuleConfigParserFactory2.createParser("json");
        // parser1和parser2是相同的
        System.out.println(parser1);
        System.out.println(parser2);
    }
}
