package com.company;
import com.company.IDB;
import com.company.Book;
import com.company.IBookRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class BookRepository implements IBookRepository{
    private final IDB db2;

    public BookRepository(IDB db2) {
        this.db2 = db2;
    }
    @Override
    public List<Book> getAllBooks() {
        Connection con2 = null;
        try {
            con2 = db2.getConnection();
            String sql = "SELECT ISBN,title,author,category FROM Book";
            Statement st2 = con2.createStatement();

            ResultSet rs2 = st2.executeQuery(sql);
            List<Book> books = new LinkedList<>();
            while (rs2.next()) {
                Book book = new Book(rs2.getInt("ISBN"),
                        rs2.getString("title"),
                        rs2.getString("author"),
                        rs2.getString("category"));

                books.add(book);
            }

            return books;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con2.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
    @Override
    public Book getBook(int ISBN) {
        Connection con2 = null;
        try {
            con2 = db2.getConnection();
            String sql = "SELECT ISBN,title,author,category FROM Book WHERE ISBN=?";
            PreparedStatement st2 = con2.prepareStatement(sql);

            st2.setInt(1, ISBN);

            ResultSet rs2 = st2.executeQuery();
            if (rs2.next()) {
                Book book = new Book(rs2.getInt("ISBN"),
                        rs2.getString("title"),
                        rs2.getString("author"),
                        rs2.getString("category"));

                return book;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con2.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean addBook(Book book) {
        Connection con2 = null;
        try {
            con2 = db2.getConnection();
            String sql = "INSERT INTO Users(ISBN,title,author,category) VALUES (?,?,?,?)";
            PreparedStatement st2 = con2.prepareStatement(sql);

            st2.setInt(1,book.getISBN());
            st2.setString(2, book.getTitle());
            st2.setString(3, book.getAuthor());
            st2.setString(4, book.getCategory());

            st2.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con2.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
}
