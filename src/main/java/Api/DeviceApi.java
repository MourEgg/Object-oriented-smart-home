package Api;

import Devices.DeviceStates.DeviceState;

public interface DeviceApi {

    void setState(DeviceState state);
    int getUseCount();
    int totalPowerConsumption();
    DeviceState getState();
    String getDeviceName();
}
