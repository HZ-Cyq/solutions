package design_pattern.structural.bridge.devices;

/**
 * @author chenyuqun
 * @date 2020/11/17 2:39 下午
 */
public class RadioDevice extends DeviceBasic {

    @Override
    public void setVolume(int volume) {
        System.out.println("set Radio volume");
        super.setVolume(volume);
    }

    @Override
    public int getVolume() {
        System.out.println("get Radio volume");
        return super.getVolume();
    }

    @Override
    public void printState() {
        System.out.println("I am Radio, my volume is: " + volume);
    }
}
