public enum Continent {
    Europe("EU"), Asia("AS"), Africa("AF"), SouthAmerica("SA");

    private String value;

    Continent(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
