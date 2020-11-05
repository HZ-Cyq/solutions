package design_pattern.creational.factory.abstract_facory;

import design_pattern.creational.factory.IRuleConfigParser;

/**
 * @author chenyuqun
 */
public class JsonConfigParserFactory implements IConfigParserFactory {
    @Override
    public IRuleConfigParser createRuleParser() {
        return null;
    }

    @Override
    public ISystemConfigParser creteSystemParser() {
        return null;
    }
}
