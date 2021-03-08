package com.company;

import com.company.IDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;

public class PostgresDB implements IDB{
    
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        
        Connection dinoConnection = null;
       
        try {
            //Here we load the driver’s class file into memory at the runtime
            Class.forName("org.postgresql.Driver");
            
            //Establishing the connection with DB
            dinoConnection = DriverManager.getConnection("jdbc:postgresql://localhost:1780/lbrjava", "postgres", "Qqwerty1!");
            
            return dinoConnection;        
        } 
        catch (Exception dinoE) {
            System.out.println(dinoE);
            return null;
        }
    }
}
