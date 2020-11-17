package design_pattern.structural.bridge.devices;

/**
 * @author chenyuqun
 * @date 2020/11/17 2:43 下午
 */
public class AdvancedRemote extends RemoteBasic{
    public AdvancedRemote(Device device) {
        super(device);
    }

    @Override
    public void upVolume(int volume) {
        System.out.println("AdvancedRemote upVolume");
        super.upVolume(volume);
    }

    @Override
    public void downVolume(int volume) {
        System.out.println("AdvancedRemote downVolume");
        super.downVolume(volume);
    }
}
