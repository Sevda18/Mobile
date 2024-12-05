public class PriceSpecification implements Specification<Product> {
    private double minPrice;
    private double maxPrice;

    public PriceSpecification(double minPrice, double maxPrice) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    @Override
    public boolean isSatisfiedBy(Product product) {
        return product.getPrice() >= minPrice && product.getPrice() <= maxPrice;
    }
}
