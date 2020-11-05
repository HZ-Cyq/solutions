package design_pattern.creational.factory.factory_method;

import design_pattern.creational.factory.IRuleConfigParser;
import design_pattern.creational.factory.YamlRuleConfigParser;

/**
 * @author chenyuqun
 */
public class YamlRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new YamlRuleConfigParser();
    }
}
