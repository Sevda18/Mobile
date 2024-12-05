public class Motorcycle extends Product {
    private String engineType;
    private int engineCapacity;

    public Motorcycle(String name, String description, double price, String category, String engineType, int engineCapacity) {
        super(name, description, price, category);
        this.engineType = engineType;
        this.engineCapacity = engineCapacity;
    }

    @Override
    public String getSpecificDetails() {
        return "Engine Type: " + engineType + ", Capacity: " + engineCapacity + "cc";
    }
}

