package design_pattern.creational.factory.factory_method;

import design_pattern.creational.factory.IRuleConfigParser;

/**
 * @author chenyuqun
 */
public interface IRuleConfigParserFactory {
    IRuleConfigParser createParser();
}
