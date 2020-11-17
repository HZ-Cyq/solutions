package design_pattern.structural.bridge.devices;

/**
 * @author chenyuqun
 * @date 2020/11/17 2:35 下午
 */
public abstract class DeviceBasic implements Device{
    protected int volume;

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
    }
}
