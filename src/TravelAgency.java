import java.util.List;

public class TravelAgency {

    TripOfferDB tripOfferDB = new TripOfferDB();
    List<Excursion> excursions;


    public TravelAgency() {
        excursions = tripOfferDB.getTripOffer();
    }


    void addExcursion(Excursion excursion) {
        tripOfferDB.addExcursion(excursion);
    }


    void deleteExcursion(Excursion excursion) {
        tripOfferDB.deleteExcursion(excursion);
    }


    void showExcursions() {
        System.out.println();
        tripOfferDB.showExcursions();
        System.out.println();
    }


    void bookOffer(float maxPrice, int minNumberOfNights, List<Continent> continents, boolean dog) {
        Excursion excursion = null;
        boolean flag = false;

        for (Excursion i : excursions) {
            if (maxPrice < i.getPricePerNight()) {
                flag = false;
                continue;
            } else {
                flag = true;
                excursion = i;

                if (minNumberOfNights > i.getNumberOfNights()) {
                    flag = false;
                    continue;
                } else {
                    flag = true;
                    excursion = i;

                    for (Continent j : continents)
                        if (!j.getValue().equals(i.getContinent().getValue())) {
                            flag = false;
                            continue;
                        } else {
                            flag = true;
                            excursion = i;


                            if (dog && !i.isDog()) {
                                flag = false;
                                continue;
                            } else {

                                flag = true;
                                excursion = i;
                                break;
                            }
                        }
                }
            }
        }
        if (!flag) System.out.println("No offers for you");
        else {
            deleteExcursion(excursion);
            System.out.println("Excursion was booked");
        }
    }
}
