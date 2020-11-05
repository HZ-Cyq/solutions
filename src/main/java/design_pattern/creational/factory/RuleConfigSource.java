package design_pattern.creational.factory;

/**
 * @author chenyuqun
 */
public class RuleConfigSource {
    public RuleConfig load(String ruleConfigFilePath) throws Exception {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParser parser = null;
        if ("json".equalsIgnoreCase(ruleConfigFileExtension)) {
            parser = new JsonRuleConfigParser();
        } else if ("xml".equalsIgnoreCase(ruleConfigFileExtension)) {
            parser = new XmlRuleConfigParser();
        } else if ("yaml".equalsIgnoreCase(ruleConfigFileExtension)) {
            parser = new YamlRuleConfigParser();
        } else {
            throw new Exception("Rule config file format is not supported: " + ruleConfigFilePath);
        }
        String configText = "";
        // 从ruleConfigFilePath文件中读取配置文本到configText中。
        return parser.parse(configText);
    }

    private String getFileExtension(String ruleConfigPath) {
        // ...解析文件名获取扩展名，比如rule.json, 返回json
        return "json";
    }


}
