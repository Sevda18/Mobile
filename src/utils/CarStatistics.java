package utils;

import models.Product;
import java.util.List;

public class CarStatistics {
    public static double calculateAveragePrice(List<Product> products) {
        return products.stream().mapToDouble(Product::getPrice).average().orElse(0);
    }

    public static void printPriceHistogram(List<Product> products) {
        double minPrice = products.stream().mapToDouble(Product::getPrice).min().orElse(0);
        double maxPrice = products.stream().mapToDouble(Product::getPrice).max().orElse(0);
        double avgPrice = calculateAveragePrice(products);

        System.out.println("Price Distribution:");


        for (double i = minPrice; i <= maxPrice; i += 5000) {
            final double rangeStart = i;

            long count = products.stream()
                    .filter(p -> p.getPrice() >= rangeStart && p.getPrice() < rangeStart + 5000)
                    .count();
            System.out.printf("$%.0f - $%.0f: %s (%d cars)\n", rangeStart, rangeStart + 5000, "#".repeat((int) count), count);
        }

        System.out.println("Average Price: $" + avgPrice);
    }
}



