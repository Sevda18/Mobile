import models.Car;
import models.Product;
import utils.ProductFilter;
import filters.Specification;
import filters.PriceSpecification;
import filters.CategorySpecification;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {
    private static final List<Product> products = new ArrayList<>();
    private static final ProductFilter productFilter = new ProductFilter();
    private static ResourceBundle messages;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadLanguage("en"); // По подразбиране английски

        System.out.println(messages.getString("welcome"));
        seedData(); // Зареждане на примерни данни

        while (true) {
            System.out.println(messages.getString("menu"));
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    listCars();
                    break;
                case "2":
                    filterCars();
                    break;
                case "3":
                    changeLanguage();
                    break;
                case "4":
                    showStatistics();
                    break;
                case "5":
                    System.out.println(messages.getString("exit"));
                    return;
                default:
                    System.out.println(messages.getString("invalid"));
            }
        }
    }

    private static void seedData() {
        products.add(new Car("BMW X5", "Luxury SUV", 50000, "SUV", "BMW", 2018));
        products.add(new Car("Toyota Corolla", "Reliable sedan", 20000, "Sedan", "Toyota", 2016));
        products.add(new Car("Ford Mustang", "Classic muscle car", 35000, "Sport", "Ford", 2020));
    }

    private static void listCars() {
        System.out.println(messages.getString("list"));
        for (Product product : products) {
            System.out.println(product.getName() + " - $" + product.getPrice());
        }
    }

    private static void filterCars() {
        System.out.println(messages.getString("filter_prompt"));
        System.out.print(messages.getString("min_price"));
        double minPrice = scanner.nextDouble();
        System.out.print(messages.getString("max_price"));
        double maxPrice = scanner.nextDouble();
        scanner.nextLine();

        Specification<Product> spec = new PriceSpecification(minPrice, maxPrice);
        List<Product> filteredProducts = productFilter.filter(products, spec);

        System.out.println(messages.getString("filtered_results"));
        for (Product product : filteredProducts) {
            System.out.println(product.getName() + " - $" + product.getPrice());
        }
    }

    private static void changeLanguage() {
        System.out.println("Choose language: (1) English, (2) Български");
        String langChoice = scanner.nextLine();

        if ("1".equals(langChoice)) {
            loadLanguage("en");
        } else if ("2".equals(langChoice)) {
            loadLanguage("bg");
        } else {
            System.out.println(messages.getString("invalid"));
        }
    }

    private static void loadLanguage(String lang) {
        Locale locale = new Locale(lang);
        messages = ResourceBundle.getBundle("messages", locale);
    }

    private static void showStatistics() {
        double avgPrice = products.stream().mapToDouble(Product::getPrice).average().orElse(0);
        System.out.println(messages.getString("avg_price") + avgPrice);
    }
}
