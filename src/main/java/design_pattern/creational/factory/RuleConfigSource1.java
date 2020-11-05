package design_pattern.creational.factory;

/**
 * Simple Factory
 * 使用简单工厂创建parser
 *
 * @author chenyuqun
 */
public class RuleConfigSource1 {

    public RuleConfig load(String ruleConfigFilePath) throws Exception {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParser parser = RuleConfigParserFactory1.createParser(ruleConfigFileExtension);
        if (parser == null) {
            throw new Exception("Rule config file format is not supported: " + ruleConfigFilePath);
        }
        String configText = "";
        return parser.parse(configText);
    }

    private String getFileExtension(String ruleConfigFilePath) {
        String[] path = ruleConfigFilePath.split(".");
        return path[path.length - 1];
    }

}
