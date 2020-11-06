package design_pattern.creational.factory.dependence_injection;

import java.io.InputStream;
import java.util.List;

/**
 * @author chenyuqun
 */
public interface BeanConfigParser {
    List<BeanDefinition> parse(InputStream inputStream);
    List<BeanDefinition> parse(String configContext);
}
