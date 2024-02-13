package jm.task.core.jdbc.util;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class Util {

    static String url = "jdbc:mysql://localhost:3306/kata";
    static String name = "root";
    static String psw = "root";

    public static Connection getNewConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, name, psw);
        } catch (SQLException | ClassNotFoundException e) {
            e.getStackTrace();
        }

        return connection;
    }
}

