package design_pattern.creational.factory.factory_method;

import design_pattern.creational.factory.IRuleConfigParser;

import java.util.HashMap;
import java.util.Map;

/**
 * 工厂方法模式。
 *
 * @author chenyuqun
 */
public class RuleConfigParserFactoryMap {

    private static final Map<String, IRuleConfigParserFactory> cachedFactories = new HashMap<>();

    static {
        cachedFactories.put("json", new JsonRuleConfigParserFactory());
        cachedFactories.put("xml", new XmlRuleConfigParserFactory());
        cachedFactories.put("yaml", new YamlRuleConfigParserFactory());
    }

    public static IRuleConfigParserFactory getParserFactory(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        }
        IRuleConfigParserFactory parserFactory = cachedFactories.get(type.toLowerCase());
        return parserFactory;
    }

    public static void main(String[] args) {
        IRuleConfigParserFactory parserFactory = RuleConfigParserFactoryMap.getParserFactory("json");
        IRuleConfigParser parser1 = parserFactory.createParser();
        IRuleConfigParser parser2 = parserFactory.createParser();
        // parser1和parser2不相等
        System.out.println(parser1);
        System.out.println(parser2);
    }
}
