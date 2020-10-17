package Api;

import Devices.Device;
import Devices.DeviceStates.DeviceIdle;
import Devices.DeviceStates.DeviceOff;
import Devices.DeviceStates.DeviceOn;
import HouseParts.Garage;
import HouseParts.Room;
import PeopleAnimals.Animal;
import PeopleAnimals.Person;
import Vehicles.Vehicle;

import java.util.List;

public class PersonApi {

    public void useDevice(Person person, Device device){
        if(device.getState().equals(new DeviceOn(device)) || device.getState().equals(new DeviceIdle(device))){
            device.setState(new DeviceOff(device));
        }
        else {
            device.setState(new DeviceOn(device));
        }
        person.getUsedDevices().add(device);
    }

    public void petAnimal(Person person, Animal animal){
        animal.pet();
        person.getUsedPets().add(animal);
    }

    public void useVehicle(Person person, Garage garage, Vehicle vehicle){
        person.setRoomIn(garage);
        if(person.getUsingVehicle() == null) {
            person.setUsingVehicle(garage.useVehicle(vehicle));
            person.getUsedVehicles().add(vehicle);
        }
    }

    public void returnVehicle(Person person, Garage garage){
        if(person.getUsingVehicle() != null) {
            garage.returnVehicle(person.getUsingVehicle());
        }
        person.setUsingVehicle(null);
    }

    public void moveToRoom(Person person, Room room){
        person.setRoomIn(room);
    }

    String animalUseReport(Person person){
        String ret = "Animal usage: " + "\r\n";
        List<Animal> a = person.getUsedPets();
        int num = 1;
        while(!a.isEmpty()){
            int count = 1;
            Animal animal = a.get(0);
            a.remove(animal);
            while(a.remove(animal)){
                count++;
            }
            ret = ret + ("Animal " + num + " petted " + count + "x." + "\r\n");
            num++;
        }
        return ret;
    }

    String deviceUseReport(Person person){
        String ret = "Devices usage" + "\r\n";
        List<Device> a = person.getUsedDevices();
        while(!a.isEmpty()){
            int count = 1;
            Device device = a.get(0);
            a.remove(device);
            while(a.remove(device)){
                count++;
            }
            ret = ret + (device.getDeviceName() + " used " + count + "x." + "\r\n");
        }
        return ret;
    }

    String vehicleUseReport(Person person){
        String ret = "Vehicles usage: " + "\r\n";
        List<Vehicle> a = person.getUsedVehicles();
        while(!a.isEmpty()){
            int count = 1;
            Vehicle vehicle = a.get(0);
            a.remove(vehicle);
            while(a.remove(vehicle)){
                count++;
            }
            ret = ret + (vehicle.getVehicleName() + " used " + count + "x."+ "\r\n");
        }
        return ret;
    }


    public String useReport(Person person){
        return animalUseReport(person) + "\r\n" + deviceUseReport(person) + "\r\n" + vehicleUseReport(person);
    }

}
