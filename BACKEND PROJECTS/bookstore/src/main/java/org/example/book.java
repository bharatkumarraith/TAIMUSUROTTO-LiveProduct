package org.example;

public class book {
    String ISBNnumber;
    String title;
    String description;
    float price;
    author auth;

    public author getAuth() {
        return auth;
    }

    public void setAuth(author auth) {
        this.auth = auth;
    }

    public String getISBNnumber() {
        return ISBNnumber;
    }

    public void setISBNnumber(String ISBNnumber) {
        this.ISBNnumber = ISBNnumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "book{" +
                "ISBNnumber='" + ISBNnumber + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", auth=" + auth +
                '}';
    }
}


