package ce.pshl.models;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private int id;
    private String name;
    private String category;
    private BigDecimal price;
    private String link;
    private String image;
    private boolean tried;
    private int rating;
    private String review;

    public Product() {
        this.id = 0;
        this.name = "";
        this.category = "";
        this.price = BigDecimal.ZERO;
        this.link = "";
        this.image = "";
        this.tried = false;
        this.rating = 0;
        this.review = "";
    }

    public Product(int id, String name, String category, BigDecimal price, String link, String image, boolean tried, int rating, String review) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.link = link;
        this.image = image;
        this.tried = tried;
        this.rating = rating;
        this.review = review;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean getTried() {
        return tried;
    }

    public void setTried(boolean tried) {
        this.tried = tried;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return getId() == product.getId() && getTried() == product.getTried() && getRating() == product.getRating() && getName().equals(product.getName()) && getCategory() == product.getCategory() && getPrice().equals(product.getPrice()) && Objects.equals(getLink(), product.getLink()) && Objects.equals(getImage(), product.getImage()) && Objects.equals(getReview(), product.getReview());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCategory(), getPrice(), getLink(), getImage(), getTried(), getRating(), getReview());
    }

}
