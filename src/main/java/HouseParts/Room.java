package HouseParts;

import Devices.*;
import PeopleAnimals.Animal;
import PeopleAnimals.Person;

import java.util.ArrayList;
import java.util.List;


public class Room {

    private List<Window> windows = new ArrayList<>();
    private List<Device> devices = new ArrayList<>();
    private List<Person> people = new ArrayList<>();
    private List<Animal> animals = new ArrayList<>();

    public Room addPerson(Person person){
        people.add(person);
        return this;
    }

    public void removePerson(Person person){
        people.remove(person);
    }

    public List<Window> getWindows() {
        return windows;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public List<Person> getPeople() {
        return people;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public Room addAnimal(Animal animal) {
        animals.add(animal);
        return this;
    }

    public void addWindow(Window window){
        windows.add(window);
    }
    public void addDevice(Device device){
        devices.add(device);
    }
}
