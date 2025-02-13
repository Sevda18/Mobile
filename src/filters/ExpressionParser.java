package filters;

import models.Car;
import models.Product;
import java.util.Arrays;
import java.util.List;

public class ExpressionParser {
    public static Specification<Product> parse(String expression) {
        List<String> conditions = Arrays.asList(expression.split("&")); // Разделя по AND

        return product -> conditions.stream().allMatch(cond -> {
            String[] parts = cond.trim().split("=");
            if (parts.length == 2) {
                String key = parts[0].trim();
                String value = parts[1].trim().replace("\"", "");

                return switch (key) {
                    case "brand" -> product.getCategory().equalsIgnoreCase(value);
                    case "year" -> product instanceof Car && ((Car) product).getYear() > Integer.parseInt(value);
                    case "price" -> product.getPrice() > Double.parseDouble(value);
                    default -> false;
                };
            }
            return false;
        });
    }
}
