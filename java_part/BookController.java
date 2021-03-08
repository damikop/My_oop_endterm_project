package com.company;

import com.company.Book;
import com.company.IBookRepository;

import java.util.List;

//this class for creating book operations: view, find and add
public class BookController {
    //implementing the interface of repository
    private final IBookRepository dinoRepo2;

    public BookController(IBookRepository dinoRepo2) {
        this.dinoRepo2 = dinoRepo2;
    }

    //view all books from database
    public String getAllBooks() {
        List<Book> books = dinoRepo2.getAllBooks();
        return books.toString();
    }

    //find book by its ISBN (ID)
    public String getBook(int ISBN) {
        Book book = dinoRepo2.getBook(ISBN);
        //if database does not contain given ID it will output "Book was not found!"
        return (book == null ? "Book was not found!" : book.toString());
    }
    
    //
    public String addBook(int ISBN, String title, String author, String category) {

        Book book = new Book(ISBN, title, author, category);
        boolean dinoCreated2 = dinoRepo2.addBook(book);
        return (dinoCreated2 ? "Book was added!" : "Book did not add!");
    }
}
