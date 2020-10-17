package Control.DeviceControlStrategy;

import Devices.Device;
import Devices.DeviceStates.DeviceIdle;
import Devices.DeviceStates.DeviceOn;
import HouseParts.Home;

public class PowerStrategy extends Strategy {

    int maxConsumedPower;

    public PowerStrategy(Home home, int maxConsumedPower) {
        super(home);
        this.maxConsumedPower = maxConsumedPower;
    }

    public void setMaxConsumedPower(int maxConsumedPower) {
        this.maxConsumedPower = maxConsumedPower;
    }

    @Override
    public void controlDevices() {
        for (Device device: devices) {
            if(device.getState().equals(new DeviceOn(device))){
                if(device.totalPowerConsumption() > maxConsumedPower){
                    device.setState(new DeviceIdle(device));
                }
            }
        }
    }
}
