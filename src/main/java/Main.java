import Api.BlindsApi;
import Api.HomeApi;
import Api.PersonApi;
import Control.DeviceControlStrategy.PowerStrategy;
import Control.DoStuff;
import HouseParts.Home;
import PeopleAnimals.Person;
import Reports.FullReport;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;


public class Main {

    public static void main(String[] args) {
        HomeApi homeApi = new HomeApi();
        Home home = homeApi.newHome(2, 3, 6, 4);
        DoStuff run = new DoStuff(home);
        run.go();
        FullReport fullReport = new FullReport();
        try {
            fullReport.houseReport(home);
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
