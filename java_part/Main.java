package com.company;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import com.company.IDB;
//import com.company.UserController;
//import com.company.UserRepository;
//import com.company.IUserRepository;

import com.company.BookController;
import com.company.BookRepository;
import com.company.IBookRepository;
import com.company.Book;
public class Main {

    public static void main(String[] args) {
//        IDB db = new PostgresDB();
//        IUserRepository repo = new UserRepository(db);
//        UserController controller = new UserController(repo);
//        MyApplication app = new MyApplication(controller);
//        app.start();
        IDB db2 = new PostgresDB();
        IBookRepository repo2=new BookRepository(db2);
        BookController controller2 = new BookController(repo2);
        MyApp app2 = new MyApp(controller2);
        app2.start2();
    }
}



