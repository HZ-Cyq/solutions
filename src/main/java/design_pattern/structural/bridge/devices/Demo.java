package design_pattern.structural.bridge.devices;

/**
 * @author chenyuqun
 * @date 2020/11/17 2:45 下午
 */
public class Demo {
    public static void main(String[] args) {
        // 控制TV的BasicRemote
        Remote basicTVRemote = new BasicRemote(new TVDevice());
        // 控制Radio的BasicRemote
        Remote basicRadioRemote = new BasicRemote(new RadioDevice());
        // 控制TV的AdvancedRemote
        Remote advancedTVRemote = new AdvancedRemote(new TVDevice());
        // 控制Radio的AdvancedRemote
        Remote advancedRadioRemote = new AdvancedRemote(new RadioDevice());

        upVolume(basicTVRemote);
        upVolume(basicRadioRemote);
        upVolume(advancedTVRemote);
        upVolume(advancedRadioRemote);
    }

    public static void upVolume(Remote remote) {
        remote.upVolume(10);
        remote.getDevice().printState();
        System.out.println("---------------------");
    }
}
