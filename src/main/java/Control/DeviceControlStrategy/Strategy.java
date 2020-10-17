package Control.DeviceControlStrategy;

import Devices.Device;
import HouseParts.Floor;
import HouseParts.Home;
import HouseParts.Room;
import HouseParts.Window;

import java.util.ArrayList;
import java.util.List;

public abstract class Strategy {

    List<Device> devices = new ArrayList<>();

    public Strategy(Home home){
        for (Floor floor: home.getFloors()) {
            for (Room room: floor.getRooms()) {
                for (Device device: room.getDevices()) {
                    devices.add(device);
                }
            }
        }
    }

    public abstract void controlDevices();
}
