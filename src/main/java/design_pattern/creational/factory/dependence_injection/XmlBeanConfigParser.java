package design_pattern.creational.factory.dependence_injection;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyuqun
 */
public class XmlBeanConfigParser implements BeanConfigParser{
    @Override
    public List<BeanDefinition> parse(InputStream inputStream) {
        String content = null;
        // ...
        return parse(content);
    }

    @Override
    public List<BeanDefinition> parse(String configContext) {
        List<BeanDefinition> beanDefinitions = new ArrayList<>();
        // ...
        return beanDefinitions;
    }
}
