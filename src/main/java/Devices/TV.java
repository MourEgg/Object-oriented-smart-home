package Devices;

import Devices.DeviceStates.DeviceBroken;
import Devices.DeviceStates.DeviceState;

public class TV extends Device {

    private int consupmtionInUse = 7;
    private int consupmtionInIdle = 3;
    private int healthInUse = 5;
    private int healthInIdle = 3;
    static int callerCounter=0;

    public TV(){
        callerCounter++;
    }

    public void setState(DeviceState state) {
        if(state.equals(new DeviceBroken(this::setState))){
            if(fixDevice()){
                setCurrentHealth(100);
            }
            else {
                return;
            }
        }
        super.setState(state);
        setCurrentHealth(getHealth());
    }

    @Override
    public int getConsupmtion(){
        if(getState().equals(new DeviceBroken(this::setState))){
            return consupmtionInUse;
        }
        else if(getState().equals(new DeviceBroken(this::setState))) {
            return consupmtionInIdle;
        }
        else {
            return 0;
        }
    }

    public int getHealth(){
        return (getMaxHealth() - (healthInUse*getOnStateCount() + healthInIdle*getIdleStateCount()));
    }

    @Override
    public int totalPowerConsumption() {
        return (getIdleStateCount()*consupmtionInIdle + getOnStateCount()*consupmtionInUse);
    }

    @Override
    public String getDeviceName() {
        return "TV" + callerCounter;
    }


}
