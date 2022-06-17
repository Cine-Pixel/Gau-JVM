public class Book {
    String id;
    String name;
    String author;
    String releaseDate;
    String price;

    public Book() {
    }

    public Book(String id, String name, String author, String release_date, String price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.releaseDate = release_date;
        this.price = price;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(String date) {
        this.releaseDate = date;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
