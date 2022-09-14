package mobinusi.handler;

import com.alibaba.fastjson.JSONObject;
import mobinusi.HandlerMethodCode;
import mobinusi.Player;
import mobinusi.service.EquipService;
import netscape.javascript.JSObject;

@HandlerAnnotation(handlerCode = HandlerMethodCode.EQUIP_CARD_1000_00)
public class EquipHandler implements ConsumeMsgHandler {

    @HandlerMethodAnnotation(methodCode = HandlerMethodCode.EQUIP_CARD_EQUIP_1000_01, desc = "穿上装备")
    public JSObject equip(Player player, JSONObject json) {
        // 解析json
        Integer pos = json.getInteger("pos");
        String equipCardId = json.getString("equipCardId");
        EquipService.equip(player, pos, equipCardId);
        return null;
    }

    @HandlerMethodAnnotation(methodCode = HandlerMethodCode.EQUIP_CARD_TAKE_OFF_1000_02, desc = "脱下装备")
    public JSONObject takeOff(Player player, JSONObject json){
        EquipService.takeOff();
        return null;
    }
}
