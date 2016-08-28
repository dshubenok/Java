package com.vk.shubenok.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class ConnectionSingleton {
    private static final String URL = "jdbc:mysql://localhost:3306/contacts";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "pass";

    private static Connection connection;

    private ConnectionSingleton() {}

    static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed())
            return connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return connection;
    }
}
