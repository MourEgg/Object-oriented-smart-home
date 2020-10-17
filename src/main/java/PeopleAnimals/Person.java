package PeopleAnimals;

import Devices.Device;
import HouseParts.Room;
import Vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Person {
    Room roomIn;
    Vehicle usingVehicle;
    List<Device> usedDevices = new ArrayList<>();
    List<Vehicle> usedVehicles = new ArrayList<>();
    List<Animal> usedPets = new ArrayList<>();

    public Vehicle getUsingVehicle() {
        return usingVehicle;
    }

    public Room getRoomIn() {
        return roomIn;
    }

    public void setRoomIn(Room roomIn) {
        this.roomIn = roomIn;
    }

    public void setUsingVehicle(Vehicle usingVehicle) {
        this.usingVehicle = usingVehicle;
    }

    public List<Device> getUsedDevices() {
        return usedDevices;
    }

    public List<Vehicle> getUsedVehicles() {
        return usedVehicles;
    }

    public List<Animal> getUsedPets() {
        return usedPets;
    }
}
