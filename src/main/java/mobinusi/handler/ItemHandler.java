package mobinusi.handler;

import com.alibaba.fastjson.JSONObject;
import mobinusi.Player;
import mobinusi.service.EquipService;
import netscape.javascript.JSObject;

@LogicHandlerAnnotation(modelCode = 100000, desc = "装备相关")
public class ItemHandler implements ILogicHandler {

    @LogicMethodAnnotation(opCode = 100001, desc = "穿上装备")
    public JSObject equip(Player player, JSONObject json) {
        // 解析json
        Integer pos = json.getInteger("pos");
        String equipCardId = json.getString("equipCardId");
        EquipService.equip(player, pos, equipCardId);
        return null;
    }

    @LogicMethodAnnotation(opCode = 100002, desc = "脱下装备")
    public JSONObject takeOff(Player player, JSONObject json) {
        ///
        return null;
    }
}
