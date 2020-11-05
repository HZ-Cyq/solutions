package design_pattern.creational.factory.factory_method;

import design_pattern.creational.factory.IRuleConfigParser;
import design_pattern.creational.factory.JsonRuleConfigParser;

/**
 * @author chenyuqun
 */
public class JsonRuleConfigParserFactory implements IRuleConfigParserFactory{
    @Override
    public IRuleConfigParser createParser() {
        return new JsonRuleConfigParser();
    }
}
