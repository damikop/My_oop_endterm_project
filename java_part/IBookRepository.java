package com.company;
import com.company.Book;
import java.util.List;
public interface IBookRepository {
    List<Book> getAllBooks();
    Book getBook(int ISBN);
    boolean addBook(Book book);
}
