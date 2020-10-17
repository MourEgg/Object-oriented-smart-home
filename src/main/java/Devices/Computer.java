package Devices;

import Devices.DeviceStates.DeviceBroken;
import Devices.DeviceStates.DeviceState;

public class Computer extends Device {

    private int consupmtionInUse = 5;
    private int consupmtionInIdle = 2;
     private int healthInUse = 10;
    private int healthInIdle = 2;
    static int callerCounter=0;

    public Computer(){
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
        return "Computer" + callerCounter;
    }


}
