import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TripOfferDB {
    List<Excursion> excursions = new ArrayList<>();


    public TripOfferDB() {
        try {
            File database = new File("TripOfferDB.txt");
            Scanner myReader = new Scanner(database);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] s = line.split(", ");
                Continent continent = Continent.Europe;
                for (Continent i : Continent.values())
                    if (i.getValue().equals(s[2])) continent = i;
                excursions.add(new Excursion(
                        Float.parseFloat(s[0]),
                        Integer.parseInt(s[1]),
                        continent,
                        Boolean.parseBoolean(s[3])));
            }
            myReader.close();
            System.out.println("Data was successfully read from file");
        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("File doesn't exist.");
        }
    }


    List<Excursion> getTripOffer() {
        return excursions;
    }


    void addExcursion(Excursion excursion) {
        boolean flag = false;
        try {
            File database = new File("TripOfferDB.txt");
            Scanner myReader = new Scanner(database);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] s = line.split(", ");
                Continent continent = Continent.Europe;
                for (Continent i : Continent.values())
                    if (i.getValue().equals(s[2])) continent = i;
                Excursion ex = new Excursion(
                        Float.parseFloat(s[0]),
                        Integer.parseInt(s[1]),
                        continent,
                        Boolean.parseBoolean(s[3]));
                if (ex.writeToFile().equals(excursion.writeToFile())) {
                    flag = true;
                    break;
                }
            }
            myReader.close();
        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("File doesn't exist.");
        }
        if (flag) System.out.println("Excursion already exists");
        else {
            excursions.add(excursion);
            saveToDB();
            System.out.println("Excursion was successfully added to file.");
        }
    }


    void deleteExcursion(Excursion excursion) {
        boolean flag = false;
        Excursion ex = null;
        try {
            File database = new File("TripOfferDB.txt");
            Scanner myReader = new Scanner(database);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] s = line.split(", ");
                Continent continent = Continent.Europe;
                for (Continent i : Continent.values())
                    if (i.getValue().equals(s[2])) continent = i;
                ex = new Excursion(
                        Float.parseFloat(s[0]),
                        Integer.parseInt(s[1]),
                        continent,
                        Boolean.parseBoolean(s[3]));

                if (ex.writeToFile().equals(excursion.writeToFile())) {
                    flag = true;
                    break;
                }
            }
            myReader.close();
        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("File doesn't exist.");
        }
        if (!flag) System.out.println("Excursion is not in our offer");
        else {
            excursions.remove(ex);
            saveToDB();
            System.out.println("Excursion was successfully deleted from file.");
        }
    }


    void showExcursions() {
        System.out.println("Current DataBase of Trip Offers:");
        for (Excursion i : excursions)
            System.out.print(i);
        System.out.println();
    }


    void saveToDB() {
        try {
            FileWriter myWriter = new FileWriter("TripOfferDB.txt");
            for (Excursion i : excursions)
                try {
                    myWriter.write(i.writeToFile() + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            myWriter.close();
        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("File doesn't exist.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}
