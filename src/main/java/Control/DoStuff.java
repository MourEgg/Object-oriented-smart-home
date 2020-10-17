package Control;

import Control.DeviceControlStrategy.PowerStrategy;
import Control.DeviceControlStrategy.Strategy;
import HouseParts.Home;

public class DoStuff {

    private Home home;
    private Strategy powerStrategy;

    public DoStuff(Home home){
        this.home = home;

    }

    public void go(){
        HouseControl hc = HouseControl.getInstance(home);
        if(powerStrategy == null) {
            setPowerStrategy(new PowerStrategy(home, 50));
        }
        hc.setDeviceStrategy(powerStrategy);
        PeopleControl pc = new PeopleControl(home);
        for(int i = 0; i < 48; i++){
            pc.nextMove();
            hc.controlDevices();
        }

    }

    public void setPowerStrategy(Strategy powerStrategy) {
        this.powerStrategy = powerStrategy;
    }
}
