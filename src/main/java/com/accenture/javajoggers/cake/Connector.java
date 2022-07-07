package com.accenture.javajoggers.cake;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connector {

    public Connection getConnection() {
        Properties connectionProps = new Properties();
        connectionProps.put("user", "root");
        connectionProps.put("password", "secret");
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cakes", connectionProps);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return conn;
    }

}
