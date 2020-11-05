package design_pattern.creational.factory.factory_method;

import design_pattern.creational.factory.IRuleConfigParser;
import design_pattern.creational.factory.XmlRuleConfigParser;

/**
 * @author chenyuqun
 */
public class XmlRuleConfigParserFactory implements IRuleConfigParserFactory{
    @Override
    public IRuleConfigParser createParser() {
        return new XmlRuleConfigParser();
    }
}
