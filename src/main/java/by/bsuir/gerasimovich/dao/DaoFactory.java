package by.bsuir.gerasimovich.dao;

/**
 * @author Tatiana
 * @version 1.00 07.04.2015.
 */
import java.sql.Connection;

/**
 * Фабрика объектов для работы с базой данных
 */
public interface DaoFactory {
    public GenericDao getDao(Class entityClass)
            throws PersistException;

   }
