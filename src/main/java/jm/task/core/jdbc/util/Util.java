package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {

    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/kata";
    private static final String NAME = "root";
    private static final String PSW = "root";

    public static Connection getNewConnection() {

        Connection connection = null;

        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(URL, NAME, PSW);
        } catch (SQLException | ClassNotFoundException e) {
            e.getStackTrace();
        }

        return connection;
    }
}
