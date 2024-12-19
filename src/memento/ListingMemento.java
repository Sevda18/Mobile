package memento;

public class ListingMemento {
    private final String title;
    private final double price;
    private final String image;

    public ListingMemento(String title, double price, String image) {
        this.title = title;
        this.price = price;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }
}
