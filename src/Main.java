import java.util.ArrayList;
import java.util.List;

import filters.Specification;
import utils.ProductFilter;
import filters.CategorySpecification;
import filters.PriceSpecification;
import filters.AndSpecification;
import models.Product;
import models.Car;
import models.Boat;
import notifier.EmailNotifier;
import notifier.EmailNotifierAdapter;
import notifications.NotificationService;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Car("Tesla Model 3", "Electric Car", 45000, "Vehicle", "Tesla", 2022));
        products.add(new Car("Toyota Corolla", "Sedan Car", 25000, "Vehicle", "Toyota", 2020));
        products.add(new Boat("Yamaha SX190", "Sport Boat", 35000, "Watercraft", 5.5, "Fiberglass"));
        products.add(new Boat("Bayliner Element", "Fishing Boat", 20000, "Watercraft", 4.3, "Aluminum"));
        products.add(new Car("Ford F-150", "Truck", 30000, "Vehicle", "Ford", 2021));
        products.add(new Boat("Sea Ray", "Luxury Boat", 55000, "Watercraft", 8.0, "Composite"));

        Specification<Product> vehicleCategorySpec = new CategorySpecification("Vehicle");
        Specification<Product> priceRangeSpec = new PriceSpecification(20000, 40000);

        Specification<Product> combinedVehicleSpec = new AndSpecification<>(vehicleCategorySpec, priceRangeSpec);

        ProductFilter filter = new ProductFilter();
        List<Product> filteredVehicles = filter.filter(products, combinedVehicleSpec);

        System.out.println("Filtered Vehicles:");
        for (Product product : filteredVehicles) {
            System.out.println(product.getName() + " - " + product.getPrice() + " USD - " + product.getSpecificDetails());
        }

        NotificationService notificationService = new NotificationService();

        notificationService.addNotifier(new EmailNotifierAdapter());

        System.out.println("\nSending notifications for filtered vehicles...");
        for (Product product : filteredVehicles) {
            notificationService.sendNotification(
                    "recipient@example.com",
                    "Available Vehicle: " + product.getName() + " for " + product.getPrice() + " USD."
            );
        }
    }
}