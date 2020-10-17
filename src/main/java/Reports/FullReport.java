package Reports;

import Api.PersonApi;
import Devices.Device;
import HouseParts.Floor;
import HouseParts.Home;
import HouseParts.Room;
import PeopleAnimals.Person;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class FullReport {

    private static int callerCounter=0;

    public void houseReport(Home home) throws FileNotFoundException, UnsupportedEncodingException {
        callerCounter++;
        houseConfigReport(home);
        usageReport(home);
        powerConsumption(home);
    }

    private void houseConfigReport(Home home) throws FileNotFoundException, UnsupportedEncodingException {


        //floors
        String floors = "Number of floors: " + home.getFloors().size();
        //rooms
        int roomNum = 0;
        int animalNum = 0;
        int peopleNum = 0;
        int deviceNum = 0;
        for (Floor f : home.getFloors()){
            roomNum += f.getRooms().size();
            for (Room r : f.getRooms()){
                animalNum += r.getAnimals().size();
                peopleNum += r.getPeople().size();
                deviceNum += r.getDevices().size();
            }
        }
        peopleNum += home.getGarage().getPeople().size();

        String rooms = "Number of rooms: " + roomNum;
        String animals = "Number of animals: " + animalNum;
        String people = "Number of people: " + peopleNum;
        String devices = "Number of devices: " + deviceNum;

        int vehicleNum = home.getGarage().getVehicles().size();
        for(Person p : home.getGarage().getPeople()){
            if(p.getUsingVehicle() != null && p.getUsingVehicle().getVehicleName() != "Queue"){
                vehicleNum++;
            }
        }
        String vehicles = "Number of vehicles: " + vehicleNum;

        PrintWriter writer = new PrintWriter("House_Config_Report" + callerCounter);
        writer.println(floors);
        writer.println(rooms);
        writer.println(people);
        writer.println(animals);
        writer.println(devices);
        writer.println(vehicles);
        writer.close();
    }

    private void usageReport(Home home) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("Usage report" + callerCounter);
        PersonApi personApi = new PersonApi();
        int personNum = 1;
        for (Floor f : home.getFloors()) {
            for (Room r : f.getRooms()){
                for(Person p : r.getPeople()){
                    writer.println("Person " + personNum);
                    writer.println(personApi.useReport(p));
                    personNum++;
                }
            }
        }
        for(Person p : home.getGarage().getPeople()){
            writer.println("Person " + personNum);
            writer.println(personApi.useReport(p));
            personNum++;
        }
        writer.close();
    }

    private void powerConsumption(Home home) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("Power Consumption" + callerCounter);
        for (Floor f : home.getFloors()){
            for(Room r : f.getRooms()){
                for(Device d : r.getDevices()){
                    writer.println(d.getDeviceName() + " " + d.totalPowerConsumption());
                }
                writer.println("-------------------------------------");
            }
        }
        writer.close();
    }
}
