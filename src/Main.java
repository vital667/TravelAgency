import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //create Agency and takes data from file
        TravelAgency travelAgency = new TravelAgency();

        travelAgency.showExcursions();

        Excursion venice = new Excursion(340f, 5, Continent.Europe, true);
        travelAgency.deleteExcursion(venice);
        travelAgency.showExcursions();

        travelAgency.addExcursion(venice);
        travelAgency.showExcursions();

        travelAgency.bookOffer(350f, 2, new ArrayList<>(List.of(Continent.Europe, Continent.Asia)), true);
        travelAgency.showExcursions();
    }
}
