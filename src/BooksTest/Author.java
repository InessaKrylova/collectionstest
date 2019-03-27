package BooksTest;

import java.util.List;

public class Author {
    private long authorId;
    private String firstName;
    private String lastName;
    private List<Book> books;

    public Author(long authorId, String firstName, String lastName) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}