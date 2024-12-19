package models;

public class Tractor extends Product {
    private int horsepower;
    private String fuelType;

    public Tractor(String name, String description, double price, String category, int horsepower, String fuelType) {
        super(name, description, price, category);
        this.horsepower = horsepower;
        this.fuelType = fuelType;
    }

    @Override
    public String getSpecificDetails() {
        return "Horsepower: " + horsepower + " hp, Fuel Type: " + fuelType;
    }
}
