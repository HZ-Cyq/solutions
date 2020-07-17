package design_pattern.structural.adapter.application_scenarios.detective;

/**
 * @author chenyuqun
 */
public interface ITarget {
    void function1();
    void function2();
    void function3(ParamsWrapperDefinition paramsWrapper);
    void function4();
}
