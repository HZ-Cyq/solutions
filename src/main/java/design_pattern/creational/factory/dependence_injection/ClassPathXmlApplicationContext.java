package design_pattern.creational.factory.dependence_injection;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author chenyuqun
 */
public class ClassPathXmlApplicationContext {

    private BeansFactory beansFactory;
    private BeanConfigParser beanConfigParser;

    /**
     * 组装BeanFactory和BeanConfigParser, 从classpath中加载XML格式的配置文件，通过BeanConfigParser解析为统一的BeanDefinition格式
     * 然后,BeanFactory根据BeanDefinition来创建对象。
     *
     * @param configLocation
     */
    public ClassPathXmlApplicationContext(String configLocation) {
        this.beansFactory = new BeansFactory();
        this.beanConfigParser = new XmlBeanConfigParser();
        loadBeanDefinitions(configLocation);
    }

    private void loadBeanDefinitions(String configLocation) {
        InputStream in = null;
        in = this.getClass().getResourceAsStream("/" + configLocation);
        if (in == null) {
            throw new RuntimeException("Can not find config file: " + configLocation);
        }
        List<BeanDefinition> beanDefinitions = beanConfigParser.parse(in);
        beansFactory.addBeanDefinitions(beanDefinitions);
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
