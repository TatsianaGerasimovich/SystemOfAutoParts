package by.bsuir.gerasimovich.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Tatiana
 * @version 1.00 16.04.2015.
 */
public class DBPool {
    private final String USER = "root";//Логин пользователя
    private final String PASSWORD = "pass";//Пароль пользователя
    private final String URL = "jdbc:mysql://localhost:3306/autoparts";//URL адрес
    private final String DRIVER = "com.mysql.jdbc.Driver";//Имя драйвера

    DBPool() throws PoolException {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new PoolException("Driver not found",e) ;
        }
    }
   public Connection getConnection() throws PoolException {
       Connection connection = null;
       try {
           connection = DriverManager.getConnection(URL, USER, PASSWORD);
       } catch (SQLException e) {
           throw new PoolException(e) ;
       }
       return connection;

    }

    public void putConnection(Connection connection) throws PoolException {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new PoolException(e) ;
        }
    }
}

