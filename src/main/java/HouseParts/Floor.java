package HouseParts;

import java.util.ArrayList;
import java.util.List;

public class Floor {

    private List<Room> rooms = new ArrayList<Room>();

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRoom(Room room){
        rooms.add(room);
    }
}
