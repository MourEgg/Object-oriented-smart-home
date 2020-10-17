package HouseParts;

import Vehicles.Bike;
import Vehicles.Car;
import Vehicles.Ski;
import Vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Garage extends Room{

    List<Vehicle> vehicles = new ArrayList<>();

    public Garage(){
        vehicles.add(new Bike());
        vehicles.add(new Bike());
        vehicles.add(new Ski());
        vehicles.add(new Car());
    }

    public Vehicle useVehicle(Vehicle vehicle){
        for (Vehicle v: vehicles) {
            if(v.getVehicleName().equals(vehicle.getVehicleName())){
                vehicles.remove(v);
                return vehicle;
            }
        }
        return null;
    }

    public void returnVehicle(Vehicle vehicle){
        if(vehicle.getVehicleName() != "Queue") {
            vehicles.add(vehicle);
        }
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}
