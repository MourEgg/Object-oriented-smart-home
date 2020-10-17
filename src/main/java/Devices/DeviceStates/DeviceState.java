package Devices.DeviceStates;

public abstract class DeviceState {

    protected Context context;

    protected String stateString;


    public DeviceState(Context context){
        this.context = context;
    }

    public String getStateString(){
        return stateString;
    }

    public Context getContext() {
        return context;
    }
}
