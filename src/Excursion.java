import java.util.Objects;

public class Excursion {
    private float pricePerNight;
    private int numberOfNights;
    private Continent continent;
    private boolean dog;

    public Excursion(float pricePerNight, int numberOfNights, Continent continent, boolean dog) {
        this.pricePerNight = pricePerNight;
        this.numberOfNights = numberOfNights;
        this.continent = continent;
        this.dog = dog;
    }

    public float getPricePerNight() {
        return pricePerNight;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public Continent getContinent() {
        return continent;
    }

    public boolean isDog() {
        return dog;
    }

    public String writeToFile() {
        return pricePerNight + ", " + numberOfNights + ", " + continent.getValue() + ", " + dog;
    }

    @Override
    public String toString() {
        return "(" + pricePerNight + " * " + numberOfNights + ", " + continent.getValue() + ", " + dog + ") ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Excursion excursion = (Excursion) o;
        return Float.compare(excursion.pricePerNight, pricePerNight) == 0 &&
                numberOfNights == excursion.numberOfNights &&
                dog == excursion.dog &&
                continent == excursion.continent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pricePerNight, numberOfNights, continent, dog);
    }
}
