package com.company;

import com.company.Book;

import java.util.List;

// Repository: to reduce the effort to implement data access layers for various persistence stores significantly.
public interface IBookRepository {
    List<Book> getAllBooks();
    Book getBook(int ISBN);
    boolean addBook(Book book);
}
