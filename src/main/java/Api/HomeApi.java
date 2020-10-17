package Api;

import HouseParts.Floor;
import HouseParts.Garage;
import HouseParts.Home;
import PeopleAnimals.Animal;
import PeopleAnimals.Person;

public class HomeApi extends Home{

    public Home newHome(int floors, int roomsPerFloor, int people, int animals){
        Home home = new Home();
        FloorApi newFloor = new FloorApi();
        for(int i = 0; i < floors; i++){
            Floor floor = newFloor.newFloor(roomsPerFloor);
            home.addFloor(floor);
        }
        for (int a = 0; a < animals; a++){
            home.getFloors().get(0).getRooms().get(0).addAnimal(new Animal());
        }
        for(int i = 0; i< people ; i++) {
            home.getFloors().get(0).getRooms().get(0).addPerson(new Person());
            home.getFloors().get(0).getRooms().get(0).getPeople().get(i).setRoomIn(home.getFloors().get(0).getRooms().get(0));
        }
        home.setGarage(new Garage());
        return home;
    }

}
