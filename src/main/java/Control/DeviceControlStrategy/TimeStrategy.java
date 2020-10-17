package Control.DeviceControlStrategy;

import Devices.Device;
import Devices.DeviceStates.DeviceIdle;
import Devices.DeviceStates.DeviceOn;
import HouseParts.Home;

public class TimeStrategy extends Strategy {

    int maxUseCount;

    public TimeStrategy(Home home, int maxUseCount) {
        super(home);
        this.maxUseCount = maxUseCount;
    }

    @Override
    public void controlDevices() {
        for (Device device: devices) {
            if(device.getState().equals(new DeviceOn(device))){
                if(device.getUseCount() > maxUseCount){
                    device.setState(new DeviceIdle(device));
                }
            }
        }
    }
}
