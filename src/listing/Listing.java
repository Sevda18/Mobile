package listing;

import java.util.Stack;

public class Listing {
    private String title;
    private String description;
    private double price;
    private String imageUrl;

    private Stack<Memento> history = new Stack<>();

    // Конструктор
    public Listing(String title, String description, double price, String imageUrl) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    // Запазване на текущото състояние
    public void saveState() {
        history.push(new Memento(title, description, price, imageUrl));
    }

    // Възстановяване на предишно състояние
    public void restoreState() {
        if (!history.isEmpty()) {
            Memento memento = history.pop();
            this.title = memento.getTitle();
            this.description = memento.getDescription();
            this.price = memento.getPrice();
            this.imageUrl = memento.getImageUrl();
        } else {
            System.out.println("No previous state to restore!");
        }
    }

    // Гетери и сетери
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        saveState();
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        saveState();
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        saveState();
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        saveState();
        this.imageUrl = imageUrl;
    }

    // Показване на текущото състояние
    @Override
    public String toString() {
        return "listing.Listing{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    // Memento клас
    private static class Memento {
        private final String title;
        private final String description;
        private final double price;
        private final String imageUrl;

        public Memento(String title, String description, double price, String imageUrl) {
            this.title = title;
            this.description = description;
            this.price = price;
            this.imageUrl = imageUrl;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public double getPrice() {
            return price;
        }

        public String getImageUrl() {
            return imageUrl;
        }
    }
}
