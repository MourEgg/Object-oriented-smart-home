package Control;

import Control.DeviceControlStrategy.Strategy;
import HouseParts.Blinds.BlindState;
import HouseParts.Floor;
import HouseParts.Home;
import HouseParts.Room;
import HouseParts.Window;

public class HouseControl {

    private Home home;
    private static HouseControl instance = null;
    private Strategy deviceStrategy;

    private HouseControl(Home home){
        this.home = home;
    }

    public static HouseControl getInstance(Home home) {
        if(instance == null) {
            instance = new HouseControl(home);
        }
        return instance;
    }

    void controlBlinds(BlindState state){
        for (Floor floor: home.getFloors()) {
            for (Room room: floor.getRooms()) {
                for (Window window: room.getWindows()) {
                    if(!window.getBlind().getState().equals(state)){
                        window.getBlind().nextState();
                    }
                }
            }
        }
    }

    void controlDevices(){
        deviceStrategy.controlDevices();
    }

    void setDeviceStrategy(Strategy strategy){
        this.deviceStrategy = strategy;
    }


}
