package com.company;

import java.sql.Connection;
import java.sql.SQLException;

//interface for PostgresDB
public interface IDB {
    Connection getConnection() throws SQLException, ClassNotFoundException;
}
