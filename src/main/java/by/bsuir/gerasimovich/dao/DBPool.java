package by.bsuir.gerasimovich.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Tatiana
 * @version 1.00 27.04.2015.
 */
public class DBPool {
    private final String USER = "root";//Логин пользователя
    private final String PASSWORD = "pass";//Пароль пользователя
    private final String URL = "jdbc:mysql://localhost:3306/autoparts";//URL адрес
    private final String DRIVER = "com.mysql.jdbc.Driver";//Имя драйвера

    DBPool() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
   public Connection getConnection() {
       Connection connection = null;
       try {
           connection = DriverManager.getConnection(URL, USER, PASSWORD);
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return connection;

    }

    public void putConnection(Connection connection) throws SQLException {
        connection.close();
    }
}

