package Control;

import Api.PersonApi;
import Devices.Device;
import HouseParts.Floor;
import HouseParts.Home;
import HouseParts.Room;
import PeopleAnimals.Animal;
import PeopleAnimals.Person;
import Vehicles.Queue;
import Vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PeopleControl {

    List<Person> people = new ArrayList<>();
    Home home;

    public PeopleControl(Home home){
        this.home = home;
        for (Floor floor: home.getFloors()) {
            for (Room room: floor.getRooms()) {
                for (Person person: room.getPeople()) {
                    people.add(person);
                }
            }
        }
    }

    public void nextMove(){
        Random rand = new Random();
        for (Person person: people) {
            decideMove(person);
        }
    }

    private void decideMove(Person person){
        Random random = new Random();
        PersonApi personApi = new PersonApi();
        if(person.getUsingVehicle() != null){   //if person is using a vehicle there is 50/50 chance he will return it
            if(random.nextBoolean()){
                personApi.returnVehicle(person, home.getGarage());
            }
        }
        else {
            switch (random.nextInt(5)){
                case 0:
                    person.getRoomIn().removePerson(person);
                    Room room = randomRoom();
                    personApi.moveToRoom(person, room);
                    room.addPerson(person);
                    break;
                case 1:
                    if(person.getRoomIn().getDevices().isEmpty()){
                        break;
                    }
                    personApi.useDevice(person, randomDevice(person.getRoomIn().getDevices()));
                    break;
                case 2:
                    person.getRoomIn().removePerson(person);
                    personApi.useVehicle(person, home.getGarage(), randomVehicle());
                    personApi.moveToRoom(person, home.getGarage());
                    home.getGarage().addPerson(person);
                    break;
                case 3:
                    if(!person.getRoomIn().getAnimals().isEmpty()) {
                        personApi.petAnimal(person, randomAnimal(person.getRoomIn().getAnimals()));
                    }
                    break;
                case 4:
                    //just chill and do nothing
                    break;
            }

        }

    }

    private Animal randomAnimal(List<Animal> animals) {
        Random random = new Random();
        return animals.get(random.nextInt(animals.size()));
    }


    private Vehicle randomVehicle() {
        List<Vehicle> vehicles = home.getGarage().getVehicles();
        Random random = new Random();
        if(vehicles.isEmpty()){
            return new Queue();
        }
            return vehicles.get(random.nextInt(vehicles.size()));

    }

    private Device randomDevice(List<Device> devices) {
        Random random = new Random();
        return devices.get(random.nextInt(devices.size()));
    }

    private Room randomRoom() {
        List<Room> rooms = new ArrayList<>();
        for (Floor floor: home.getFloors()) {
            for (Room room: floor.getRooms()) {
                rooms.add(room);
            }

        }
        Random random = new Random();
        int r = random.nextInt(rooms.size());
        return rooms.get(r);
    }
    

}
