package com.company;
import com.company.IDB;
import com.company.Book;
import com.company.IBookRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
//dependency injection
public class BookRepository implements IBookRepository{
    private final IDB dinoDB2;

    public BookRepository(IDB dinoDB2) {
        this.dinoDB2 = dinoDB2;
    }
    //using exception handling we selecting all bokks in our database
    @Override
    public List<Book> getAllBooks() {
        //creating connection
        Connection dinoCon2 = null;
        try {
            dinoCon2 = dinoDB2.getConnection();
            
            String dinoSQL = "SELECT ISBN,title,author,category FROM Book";
            Statement dinoST2 = dinoCon2.createStatement();
//adding result set
            ResultSet dinoRS2 = dinoST2.executeQuery(dinoSQL);
            List<Book> books = new LinkedList<>();
            while (dinoRS2.next()) {
                Book book = new Book(dinoRS2.getInt("ISBN"),
                        dinoRS2.getString("title"),
                        dinoRS2.getString("author"),
                        dinoRS2.getString("category"));

                books.add(book);
            }

            return books;
        } catch (SQLException dinoThrow) {
            dinoThrow.printStackTrace();
        } catch (ClassNotFoundException dinoE) {
            dinoE.printStackTrace();
        } finally {
            try {
                dinoCon2.close();
            } catch (SQLException dinoThrow) {
                dinoThrow.printStackTrace();
            }
        }
        return null;
    }
    //using exception handling to get book by isbn of the book
    @Override
    public Book getBook(int ISBN) {
        Connection dinoCon2 = null;
        try {
            dinoCon2 = dinoDB2.getConnection();
            String dinoSQL = "SELECT ISBN,title,author,category FROM Book WHERE ISBN=?";
            PreparedStatement dinoST2 = dinoCon2.prepareStatement(dinoSQL);

            dinoST2.setInt(1, ISBN);

            ResultSet dinoRS2 = dinoST2.executeQuery();
            if (dinoRS2.next()) {
                Book book = new Book(dinoRS2.getInt("ISBN"),
                        dinoRS2.getString("title"),
                        dinoRS2.getString("author"),
                        dinoRS2.getString("category"));

                return book;
            }
        } catch (SQLException dinoThrow) {
            dinoThrow.printStackTrace();
        } catch (ClassNotFoundException dinoE) {
            dinoE.printStackTrace();
        } finally {
            try {
                dinoCon2.close();
            } catch (SQLException dinoThrow) {
                dinnoThrow.printStackTrace();
            }
        }
        return null;
    }
//using exception handling to add book to the database
    @Override
    public boolean addBook(Book book) {
        Connection dinoCon2 = null;
        try {
            dinoCon2 = dinoDB2.getConnection();
            //using prepared statement because we several parameters in sql statement
            String dinioSQL = "INSERT INTO Users(ISBN,title,author,category) VALUES (?,?,?,?)";
            PreparedStatement dinoST2 = dinoCon2.prepareStatement(dinoSQL);
//to bind every qustion mark we use these setInt,....
            dinoST2.setInt(1,book.getISBN());
            dinoST2.setString(2, book.getTitle());
            dinoST2.setString(3, book.getAuthor());
            dinoST2.setString(4, book.getCategory());

            dinoST2.execute();
            return true;
        } catch (SQLException dinoThrow) {
            dinoThrow.printStackTrace();
        } catch (ClassNotFoundException dinoE) {
            dinoE.printStackTrace();
        } finally {//close the connection
            try {
                dinoCon2.close();
            } catch (SQLException dinoThrow) {
                dinoThrow.printStackTrace();
            }
        }
        return false;
    }
}
