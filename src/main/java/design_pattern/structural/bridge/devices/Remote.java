package design_pattern.structural.bridge.devices;

/**
 * @author chenyuqun
 * @date 2020/11/17 2:28 下午
 */
public interface Remote {
    void upVolume(int volume);

    void downVolume(int volume);

    Device getDevice();
}
