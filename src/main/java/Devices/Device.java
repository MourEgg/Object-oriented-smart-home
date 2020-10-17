package Devices;

import Devices.DeviceStates.*;

import java.util.Random;

public abstract class Device implements Context{

    private DeviceState state = new DeviceOff(this);
    private int useCount = 0;
    private int OnStateCount = 0;
    private int IdleStateCount = 0;
    private int maxHealth = 100;
    private int currentHealth;
    private int consupmtionInUse;
    private int consupmtionInIdle;
    private int healthInUse;
    private int healthInIdle;



    public void setState(DeviceState state) {
        this.state = state;
        useCount++;
        if(state.getContext().equals(new DeviceOn(this).getContext())){
            OnStateCount++;
        }
        else if(state.getContext().equals(new DeviceIdle(this).getContext())){
            IdleStateCount++;
        }
        else if(currentHealth <= 0){
            this.state = new DeviceBroken(this);
        }

    }
    boolean fixDevice(){
        Random rand = new Random();
        return rand.nextBoolean();
    }


    public int getUseCount(){
        return useCount;
    }

    int getOnStateCount() {
        return OnStateCount;
    }

    int getIdleStateCount() {
        return IdleStateCount;
    }

    int getMaxHealth() {
        return maxHealth;
    }


    void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public DeviceState getState(){
        return state;
    }

    public abstract int getHealth();

    public abstract int totalPowerConsumption();

    public abstract String getDeviceName();

    public abstract int getConsupmtion();

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setUseCount(int useCount) {
        this.useCount = useCount;
    }

    public void setConsupmtionInUse(int consupmtionInUse) {
        this.consupmtionInUse = consupmtionInUse;
    }

    public void setConsupmtionInIdle(int consupmtionInIdle) {
        this.consupmtionInIdle = consupmtionInIdle;
    }

    public void setHealthInUse(int healthInUse) {
        this.healthInUse = healthInUse;
    }

    public void setHealthInIdle(int healthInIdle) {
        this.healthInIdle = healthInIdle;
    }
}
