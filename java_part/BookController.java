package com.company;
import com.company.Book;
import com.company.IBookRepository;

import java.util.List;
public class BookController {
    private final IBookRepository repo2;

    public BookController(IBookRepository repo2) {
        this.repo2 = repo2;
    }

    public String getAllBooks() {
        List<Book> books = repo2.getAllBooks();
        return books.toString();
    }

    public String getBook(int ISBN) {
        Book book = repo2.getBook(ISBN);

        return (book == null ? "Book was not found!" : book.toString());
    }

    public String addBook(int ISBN, String title, String author, String category) {

        Book book = new Book(ISBN, title, author, category);

        boolean created2 = repo2.addBook(book);

        return (created2 ? "Book was added!" : "Book did not add!");
    }
}
