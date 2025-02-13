package utils;

import models.Car;
import models.Product;
import java.util.List;

public class Database {
    public static List<Product> getCars() {
        return List.of(
                new Car("BMW X5", "SUV", 45000, "BMW", "BMW", 2020),
                new Car("Audi A6", "Sedan", 38000, "Audi", "Audi", 2019),
                new Car("Toyota Corolla", "Compact", 20000, "Toyota", "Toyota", 2022)
        );
    }
}
