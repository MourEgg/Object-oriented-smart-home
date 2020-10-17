package Devices.DeviceStates;

import Devices.Device;
import Devices.DeviceStates.DeviceState;

public class DeviceBroken extends DeviceState {

    public DeviceBroken(Context context) {
        super(context);
        stateString = "Broken";
    }
}
