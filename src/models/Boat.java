package models;

public class Boat extends Product {
    private double length;
    private String material;

    public Boat(String name, String description, double price, String category, double length, String material) {
        super(name, description, price, category);
        this.length = length;
        this.material = material;
    }

    @Override
    public String getSpecificDetails() {
        return "Length: " + length + " meters, Material: " + material;
    }
}
