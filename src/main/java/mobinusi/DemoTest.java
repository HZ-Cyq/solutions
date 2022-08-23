package mobinusi;

import com.alibaba.fastjson.JSONObject;

public class DemoTest {
    public static void main(String[] args) {
        // 启服务的时候init
        ILogicManager.getInstance().init("mobinusi.handler");

        Player player = new Player();
        JSONObject params = new JSONObject();
        params.put("pos", 1);
        params.put("equipCardId", "1001");

        ILogicManager.getInstance().invoke(HandlerMethodCode.EQUIP_CARD_EQUIP_1000_01, player, params);

    }
}
