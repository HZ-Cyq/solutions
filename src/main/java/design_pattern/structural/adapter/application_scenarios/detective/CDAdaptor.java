package design_pattern.structural.adapter.application_scenarios.detective;

/**
 * 封装有缺陷的接口设计
 * @author chenyuqun
 */
public class CDAdaptor extends CD implements ITarget{
    @Override
    public void function1() {
        staticFunction1();
    }

    @Override
    public void function2() {
        super.uglyNamingFunction2();
    }

    @Override
    public void function3(ParamsWrapperDefinition paramsWrapper) {
        super.tooManyParamsFunction3(paramsWrapper.getParamA(), paramsWrapper.getParamB());
    }

    @Override
    public void function4() {
        // ...reimplement it...
    }
}
