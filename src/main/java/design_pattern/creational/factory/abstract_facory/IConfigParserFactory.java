package design_pattern.creational.factory.abstract_facory;

import design_pattern.creational.factory.IRuleConfigParser;

public interface IConfigParserFactory {
    IRuleConfigParser createRuleParser();

    ISystemConfigParser creteSystemParser();
}
