package design_pattern.structural.adapter.application_scenarios.replace_external_system;

import org.junit.Test;

/** 替换依赖的外部系统：当我们把项目中依赖的一个外部系统替换为另一个外部系统的时候，利用适配器模式，可减少对代码的改动。
 * @author chenyuqun
 */
public class ReplaceTest {
    @Test
    public void testReplace() {
        // 在我们的项目中，外部系统A的使用示例
        Demo d = new Demo(new A());
        // 借助BAdaptor,Demo的代码中，调用IA接口的地方都无需改动
        // 只需要将BAdaptor如下注入到Demo即可
        Demo d1 = new Demo(new BAdaptor(new B()));
    }
}
