package design_pattern.structural.bridge.devices;

/**
 * @author chenyuqun
 * @date 2020/11/17 2:27 下午
 */
public interface Device {
    void setVolume(int volume);

    int getVolume();

    void printState();
}
