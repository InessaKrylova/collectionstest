package BooksTest;

import java.util.List;

public class Publisher {
    private long publisherId;
    private String brandName;
    private List<Book> books;

    public Publisher(long publisherId, String brandName) {
        this.publisherId = publisherId;
        this.brandName = brandName;
    }
}