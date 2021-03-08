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
        
//      Here we specified which DB
        IDB dinoDB2 = new PostgresDB();
        
//      using Repository
        IBookRepository dinoRepo2=new BookRepository(dinoDB2);
        BookController dinoController2 = new BookController(dinoRepo2);
        
//      to execute book operations
        MyApp dinoApp2 = new MyApp(dinoController2);
        
        dinoApp2.dinoStart2();
    }
}
