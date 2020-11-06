package design_pattern.creational.factory.dependence_injection;

public interface ApplicationContext {
    Object getBean(String beanId);
}
