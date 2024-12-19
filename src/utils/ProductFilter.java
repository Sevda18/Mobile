package utils;

import filters.Specification;
import models.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductFilter {
    public List<Product> filter(List<Product> products, Specification<Product> spec) {
        return products.stream()
                .filter(product -> spec.isSatisfiedBy(product))
                .collect(Collectors.toList());
    }
}
