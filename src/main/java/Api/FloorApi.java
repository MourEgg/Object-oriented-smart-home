package Api;

import HouseParts.Floor;

public class FloorApi {

    public Floor newFloor(int rooms) {
        Floor floor = new Floor();
        for (int i = 0; i < rooms; i++) {
            RoomApi room = new RoomApi();
            floor.setRoom(room.newRandomRoom());
        }
        return floor;
    }
}
