package cli;

import utils.Database;
import utils.ProductFilter;
import filters.ExpressionParser;
import filters.Specification;
import models.Product;
import utils.CarStatistics;
import utils.ResourceLoader;
import java.util.List;
import java.util.Scanner;

public class CarCLI {
    private static Scanner scanner = new Scanner(System.in);
    private static ResourceLoader loader;

    public static void main(String[] args) {
        selectLanguage();
        runMenu();
    }

    static {
        loader = new ResourceLoader("bg");
    }

    private static void selectLanguage() {
        System.out.println("Choose language / Изберете език:");
        System.out.println("1. English");
        System.out.println("2. Български");

        int choice = scanner.nextInt();
        scanner.nextLine();
        loader = new ResourceLoader(choice == 1 ? "en" : "bg");
    }

    private static void runMenu() {
        while (true) {
            System.out.println(loader.get("menu"));
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> listCars();
                case 2 -> filterCars();
                case 3 -> selectLanguage();
                case 4 -> showStatistics();
                case 5 -> exit();
                default -> System.out.println(loader.get("invalid"));
            }
        }
    }

    private static void listCars() {
        System.out.println(loader.get("list"));
        List<Product> cars = Database.getCars();
        for (Product car : cars) {
            System.out.println(car.getName() + " - $" + car.getPrice());
        }
    }

    private static void filterCars() {
        System.out.println(loader.get("filter_prompt"));
        final String filterExpression = scanner.nextLine();

        Specification<Product> filter = ExpressionParser.parse(filterExpression);
        List<Product> filtered = new ProductFilter().filter(Database.getCars(), filter);

        System.out.println(loader.get("filtered_results"));
        for (Product car : filtered) {
            System.out.println(car.getName() + " - $" + car.getPrice());
        }
    }

    private static void showStatistics() {
        double avgPrice = CarStatistics.calculateAveragePrice(Database.getCars());
        System.out.println(loader.get("avg_price") + avgPrice);
    }

    private static void exit() {
        System.out.println(loader.get("exit"));
        System.exit(0);
    }
}

