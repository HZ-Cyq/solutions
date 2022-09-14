package mobinusi;

import com.alibaba.fastjson.JSONObject;
import mobinusi.handler.ILogicManager;
import mobinusi.service.EquipService;
import org.junit.Test;


public class DemoTest {
    public static void main(String[] args) {
        // 启服务的时候init
        ILogicManager.getInstance().init();
        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
                Player player = new Player();
                JSONObject params = new JSONObject();
                params.put("pos", 1);
                params.put("equipCardId", "1001");
                ILogicManager.getInstance().invoke(HandlerMethodCode.EQUIP_CARD_EQUIP_1000_01, player, params);
            });
            threads[i] = thread;
        }
        for (int i = 0; i < 100; i++) {
            threads[i].start();
        }
        for (int i = 0; i < 100; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(EquipService.integer);
    }

    /**
     * 测试抛异常
     */
    @Test
    public void test1() {

    }
}
