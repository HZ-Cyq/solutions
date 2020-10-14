package design_pattern.structural.bridge.bridge;

import com.sun.xml.internal.ws.model.AbstractWrapperBeanGenerator;
import design_pattern.structural.bridge.prime.ApiStatInfo;
import org.junit.Test;

/**
 * @author chenyuqun
 */
public class BridgeTest {
    @Test
    public void testBridge() {
        ApiStatInfo apiStatInfo = new ApiStatInfo("test",10, 5,10);
        ApplicationContext.getInstance().getAlert().check(apiStatInfo);
//        AbstractWrapperBeanGenerator.BeanMemberFactory

    }
}
