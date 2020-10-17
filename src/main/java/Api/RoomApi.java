package Api;

import Devices.Device;
import Devices.DeviceFactory;
import HouseParts.Room;
import HouseParts.Window;


import java.util.Random;

public class RoomApi {

    public Room newRandomRoom(){
        Room room = new Room();
        for(int i = 0; i < 2; i++){
            Window window = new Window();
            room.addWindow(window);
        }
        DeviceFactory f = new DeviceFactory();
        for(int i = 0; i < 3; i++){
            Random rand = new Random();
            Device device = null;
            switch (rand.nextInt(7)) {
                case 0:
                    device = f.createComputer();
                    break;
                case 1:
                    device = f.createMicrowave();
                    break;
                case 2:
                    device = f.createNotebook();
                    break;
                case 3:
                    device = f.createRadio();
                    break;
                case 4:
                    device = f.createTablet();
                    break;
                case 5:
                    device = f.createTV();
                    break;
                case 6:
                    device = f.createVacuumCleaner();
                    break;
                case 7:
                    device = f.createLamp();
                    break;
            }
            room.addDevice(device);
        }
        return room;
    }
}
