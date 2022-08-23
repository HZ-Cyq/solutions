package mobinusi;

import com.alibaba.fastjson.JSONObject;
import mobinusi.handler.ItemHandler;
import mobinusi.handler.LogicHandlerAnnotation;
import org.junit.Test;
import org.reflections.Reflections;
import org.reflections.util.ConfigurationBuilder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DemoTest {
    public static void main(String[] args) {
        ConfigurationBuilder build = ConfigurationBuilder.build("mobinusi.handler");
        Reflections reflections = new Reflections(build);
        System.out.println(reflections);
    }
//    @Test
//    public void test() {
//        String logicHandlerPackage = "java.util";
//        ILogicManager.getInstance().init(logicHandlerPackage);
//        Method methodByOpCode = ILogicManager.getInstance().getMethodByOpCode(100001);
//        Player player = new Player();
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("pos", 1);
//        jsonObject.put("equipCardId", "1001");
//        try {
//            methodByOpCode.invoke(player, jsonObject);
//        } catch (IllegalAccessException | InvocationTargetException e) {
//            e.printStackTrace();
//        }
//    }
}
