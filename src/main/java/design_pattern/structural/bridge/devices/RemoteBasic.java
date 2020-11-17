package design_pattern.structural.bridge.devices;

/**
 * @author chenyuqun
 * @date 2020/11/17 2:29 下午
 */
public abstract class RemoteBasic implements Remote {
   protected Device device;

   public RemoteBasic(Device device) {
       this.device = device;
   }

    @Override
    public void upVolume(int volume) {
        device.setVolume(device.getVolume() + volume);
    }

    @Override
    public void downVolume(int volume) {
        device.setVolume(device.getVolume() - volume);
    }

    @Override
    public Device getDevice() {
        return device;
    }
}
