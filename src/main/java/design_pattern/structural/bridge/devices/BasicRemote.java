package design_pattern.structural.bridge.devices;

/**
 * @author chenyuqun
 * @date 2020/11/17 2:41 下午
 */
public class BasicRemote extends RemoteBasic {

    public BasicRemote(Device device) {
        super(device);
    }

    @Override
    public void upVolume(int volume) {
        System.out.println("BasicRemote upVolume");
        super.upVolume(volume);
    }

    @Override
    public void downVolume(int volume) {
        System.out.println("BasicRemote downVolume");
        super.downVolume(volume);
    }
}
