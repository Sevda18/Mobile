package models;

public class Car extends Product {
    private String brand;
    private int year;

    public Car(String name, String description, double price, String category, String brand, int year) {
        super(name, description, price, category);
        this.brand = brand;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String getSpecificDetails() {
        return "Brand: " + brand + ", Year: " + year;
    }
}
