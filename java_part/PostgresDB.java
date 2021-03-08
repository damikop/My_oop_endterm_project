package com.company;
import com.company.IDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
public class PostgresDB implements IDB{
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:1780/lbrjava", "postgres", "Qqwerty1!");
            return connection;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
