package by.bsuir.gerasimovich.dao;

import by.bsuir.gerasimovich.entity.GeneralEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Tatiana
 * @version 1.00 07.04.2015.
 */
/**
 * Абстрактный класс предоставляющий базовую реализацию CRUD операций с
 * использованием JDBC.
 *
 * @param <T> тип объекта персистенции
 */
public abstract class AbstractJDBCDao <T extends GeneralEntity> implements GenericDao<T> {

    private Connection connection;
    private DBPool pool;

    /**
     * Возвращает sql запрос для получения всех записей. SELECT * FROM [Table]
     */
    public abstract String getSelectQuery();

    /**
     * INSERT INTO [Table] ([column, column, ...]) VALUES (?, ?, ...);
     */
    public abstract String getCreateQuery();

    /**
     * UPDATE [Table] SET [column = ?, column = ?, ...] WHERE id = ?;
     */
    public abstract String getUpdateQuery();

    /**
     * DELETE FROM [Table] WHERE id= ?;
     */
    public abstract String getDeleteQuery();

    /**
     * Разбирает ResultSet и возвращает список объектов соответствующих
     * содержимому ResultSet.
     */
    protected abstract List<T> parseResultSet(ResultSet rs) throws PersistException;

    protected abstract void prepareStatementForInsert(PreparedStatement statement, T object) throws PersistException;

    protected abstract void prepareStatementForUpdate(PreparedStatement statement, T object) throws PersistException;

    @Override
    public void persist(T object) throws PersistException {
        // Добавляем запись
        String sql = getCreateQuery();
        connection = pool.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            prepareStatementForInsert(statement, object);
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new PersistException("On persist modify more then 1 record: " + count);
            }
            statement.close();
        } catch (Exception e) {
            throw new PersistException(e);
        } finally {
        try {
            if (connection != null)
                pool.putConnection(connection);
        } catch (SQLException e) {
            throw new PersistException(e);
        }
    }
}

    @Override
    public T getByPK(Integer key, String nameOfId) throws PersistException {
        List<T> list;
        String sql = getSelectQuery();
        ResultSet rs=null;
        connection = pool.getConnection();
        sql += " WHERE "+nameOfId+" = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, key);
            rs = statement.executeQuery();
            list = parseResultSet(rs);
            statement.close();
        } catch (Exception e) {
            throw new PersistException(e);
        }
        finally {
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                throw new  PersistException(e);
            }
            try {
                if (connection != null)
                    pool.putConnection(connection);
            } catch (SQLException e) {
                throw new  PersistException(e);
            }
        }
        if (list == null || list.size() == 0) {
            throw new PersistException("Record with PK = " + key + " not found.");
        }
        if (list.size() > 1) {
            throw new PersistException("Received more than one record.");
        }


        return list.iterator().next();
    }

    @Override
    public void update(T object) throws PersistException {
        String sql = getUpdateQuery();
        connection = pool.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            prepareStatementForUpdate(statement, object);
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new PersistException("On update modify more then 1 record: " + count);
            }
            statement.close();
        } catch (Exception e) {
            throw new PersistException(e);
        }finally {
            try {
                if (connection != null)
                    pool.putConnection(connection);
            } catch (SQLException e) {
                throw new  PersistException(e);
            }
        }
    }

    @Override
    public void delete(T object) throws PersistException {
        String sql = getDeleteQuery();
        connection = pool.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            try {
                statement.setObject(1, object.getId());
            } catch (Exception e) {
                throw new PersistException(e);
            }
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new PersistException("On delete modify more then 1 record: " + count);
            }
            statement.close();
        } catch (Exception e) {
            throw new PersistException(e);
        }finally {
            try {
                if (connection != null)
                    pool.putConnection(connection);
            } catch (SQLException e) {
                throw new  PersistException(e);
            }
        }
    }

    @Override
    public List<T> getAll() throws PersistException {
        List<T> list;
        ResultSet rs=null;
        connection = pool.getConnection();
        String sql = getSelectQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
             rs = statement.executeQuery();
            list = parseResultSet(rs);
            statement.close();
        } catch (Exception e) {
            throw new PersistException(e);
        }finally {
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                throw new  PersistException(e);
            }
            try {
                if (connection != null)
                    pool.putConnection(connection);
            } catch (SQLException e) {
                throw new  PersistException(e);
            }
        }

        return list;
    }

    public Connection getConnection()  {
        connection = pool.getConnection();
        return connection;
    }
    public void putConnection() throws PersistException {
        try {
            if (connection != null)
                pool.putConnection(connection);
        } catch (SQLException e) {
            throw new  PersistException(e);
        }
    }
     public AbstractJDBCDao() {
        pool=new DBPool();
    }
}
