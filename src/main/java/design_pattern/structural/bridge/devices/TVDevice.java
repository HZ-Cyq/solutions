package design_pattern.structural.bridge.devices;

/**
 * @author chenyuqun
 * @date 2020/11/17 2:35 下午
 */
public class TVDevice extends DeviceBasic {

    @Override
    public void setVolume(int volume) {
        System.out.println("set TV volume");
        super.setVolume(volume);
    }

    @Override
    public int getVolume() {
        System.out.println("get TV volume");
        return super.getVolume();
    }

    @Override
    public void printState() {
        System.out.println("I am Tv, my volume is : " + volume);
    }
}
