package memento;

public class Listing {
    private String title;
    private double price;
    private String image;

    public Listing(String title, double price, String image) {
        this.title = title;
        this.price = price;
        this.image = image;
    }

    public ListingMemento save() {
        return new ListingMemento(title, price, image);
    }

    public void restore(ListingMemento memento) {
        this.title = memento.getTitle();
        this.price = memento.getPrice();
        this.image = memento.getImage();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Listing{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }
}
