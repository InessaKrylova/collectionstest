package BooksTest;

public class Book {
    private long bookId;
    private String title;
    private int pagesNumber;
    private Author author;
    private Publisher publisher;

    public Book(long bookId, String title, int pagesNumber, Author author, Publisher publisher) {
        this.bookId = bookId;
        this.title = title;
        this.pagesNumber = pagesNumber;
        this.author = author;
        this.publisher = publisher;
    }
}