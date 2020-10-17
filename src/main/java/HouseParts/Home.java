package HouseParts;

import java.util.ArrayList;
import java.util.List;

public class Home {

    List<Floor> floors = new ArrayList<>();
    private Garage garage;

    public List<Floor> getFloors() {
        return floors;
    }

    public Garage getGarage() {
        return garage;
    }

    public void addFloor(Floor floor) {
        this.floors.add(floor);
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }
}
