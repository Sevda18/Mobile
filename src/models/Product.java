package models;

// Абстрактен клас за общите свойства на всички продукти
public abstract class Product {
    private String name;
    private String description;
    private double price;
    private String category;

    // Конструктор
    public Product(String name, String description, double price, String category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    // Абстрактен метод за получаване на допълнителни характеристики
    public abstract String getSpecificDetails();

    // Общи гетери за данни
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}
