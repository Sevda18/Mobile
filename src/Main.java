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
        // Създаваме списък с продукти
        List<Product> products = new ArrayList<>();
        products.add(new Car("Tesla Model 3", "Electric Car", 45000, "Vehicle", "Tesla", 2022));
        products.add(new Car("Toyota Corolla", "Sedan Car", 25000, "Vehicle", "Toyota", 2020));
        products.add(new Boat("Yamaha SX190", "Sport Boat", 35000, "Watercraft", 5.5, "Fiberglass"));
        products.add(new Boat("Bayliner Element", "Fishing Boat", 20000, "Watercraft", 4.3, "Aluminum"));
        products.add(new Car("Ford F-150", "Truck", 30000, "Vehicle", "Ford", 2021));
        products.add(new Boat("Sea Ray", "Luxury Boat", 55000, "Watercraft", 8.0, "Composite"));

        // Създаваме спецификации
        Specification<Product> vehicleCategorySpec = new CategorySpecification("Vehicle");
        Specification<Product> priceRangeSpec = new PriceSpecification(20000, 40000);

        // Комбинираме спецификациите за превозни средства в зададения ценови диапазон
        Specification<Product> combinedVehicleSpec = new AndSpecification<>(vehicleCategorySpec, priceRangeSpec);

        // Филтрираме продуктите
        ProductFilter filter = new ProductFilter();
        List<Product> filteredVehicles = filter.filter(products, combinedVehicleSpec);

        // Показваме резултатите
        System.out.println("Filtered Vehicles:");
        for (Product product : filteredVehicles) {
            System.out.println(product.getName() + " - " + product.getPrice() + " USD - " + product.getSpecificDetails());
        }

        // Създаваме система за известия
        NotificationService notificationService = new NotificationService();

        // Добавяме EmailNotifier чрез адаптер
        notificationService.addNotifier(new EmailNotifierAdapter());

        // Изпращаме известия за намерените продукти
        System.out.println("\nSending notifications for filtered vehicles...");
        for (Product product : filteredVehicles) {
            notificationService.sendNotification(
                    "recipient@example.com",
                    "Available Vehicle: " + product.getName() + " for " + product.getPrice() + " USD."
            );
        }
    }
}