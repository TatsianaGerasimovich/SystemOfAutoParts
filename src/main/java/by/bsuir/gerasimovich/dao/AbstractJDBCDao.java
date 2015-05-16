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
    protected abstract List<T> parseResultSet(ResultSet rs) throws DAOException;

    protected abstract void prepareStatementForInsert(PreparedStatement statement, T object) throws DAOException;

    protected abstract void prepareStatementForUpdate(PreparedStatement statement, T object) throws DAOException;

    @Override
    public void persist(T object) throws DAOException {
        // Добавляем запись
        String sql = getCreateQuery();
        try {
            connection = pool.getConnection();
        } catch (PoolException e) {
            throw new DAOException(e) ;
        }
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            prepareStatementForInsert(statement, object);
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new DAOException("On persist modify more then 1 record: " + count);
            }
            statement.close();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {

            if (connection != null)

                try {
                    pool.putConnection(connection);
                } catch (PoolException e) {
                    throw new DAOException(e) ;
                }


        }
}

    @Override
    public T getByPK(Integer key, String nameOfId) throws DAOException {
        List<T> list;
        String sql = getSelectQuery();
        ResultSet rs=null;
        try {
            connection = pool.getConnection();
        } catch (PoolException e) {
            throw new DAOException(e) ;
        }
        sql += " WHERE "+nameOfId+" = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, key);
            rs = statement.executeQuery();
            list = parseResultSet(rs);
            statement.close();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        finally {
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                throw new  DAOException(e);
            }

                if (connection != null)
                    try {
                        pool.putConnection(connection);
                    } catch (PoolException e) {
                        throw new  DAOException(e);
                    }

        }
        if (list == null || list.size() == 0) {
            throw new DAOException("Record with PK = " + key + " not found.");
        }
        if (list.size() > 1) {
            throw new DAOException("Received more than one record.");
        }
        return list.iterator().next();
    }

    @Override
    public void update(T object) throws DAOException {
        String sql = getUpdateQuery();
        try {
            connection = pool.getConnection();
        } catch (PoolException e) {
            throw new  DAOException(e);
        }
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            prepareStatementForUpdate(statement, object);
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new DAOException("On update modify more then 1 record: " + count);
            }
            statement.close();
        } catch (SQLException e) {
            throw new DAOException(e);
        }finally {

                if (connection != null)
                    try {
                        pool.putConnection(connection);
                    } catch (PoolException e) {
                        throw new  DAOException(e);
                    }

        }
    }

    @Override
    public void delete(T object) throws  DAOException {
        String sql = getDeleteQuery();
        try {
            connection = pool.getConnection();
        } catch (PoolException e) {
            throw new  DAOException(e);
        }
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            try {
                statement.setObject(1, object.getId());
            } catch (SQLException e) {
                throw new DAOException(e);
            }
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new DAOException("On delete modify more then 1 record: " + count);
            }
            statement.close();
        } catch (SQLException e) {
            throw new DAOException(e);
        }finally {

                if (connection != null)
                    try {
                        pool.putConnection(connection);
                    } catch (PoolException e) {
                        throw new DAOException(e);
                    }

        }
    }

    @Override
    public List<T> getAll() throws DAOException {
        List<T> list;
        ResultSet rs=null;
        try {
            connection = pool.getConnection();
        } catch (PoolException e) {
            throw new DAOException(e);
        }
        String sql = getSelectQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
             rs = statement.executeQuery();
            list = parseResultSet(rs);
            statement.close();
        } catch (SQLException e) {
            throw new DAOException(e);
        }finally {
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                throw new  DAOException(e);
            }

                if (connection != null)
                    try {
                        pool.putConnection(connection);
                    } catch (PoolException e) {
                        throw new  DAOException(e);
                    }

        }

        return list;
    }

    public Connection getConnection() throws DAOException {
        try {
            connection = pool.getConnection();
        } catch (PoolException e) {
            throw new  DAOException(e);
        }
        return connection;
    }
    public void putConnection() throws DAOException {

            if (connection != null)
                try {
                    pool.putConnection(connection);
                } catch (PoolException e) {
                    throw new  DAOException(e);
                }

    }
     public AbstractJDBCDao() throws DAOException {
         try {
             pool=new DBPool();
         } catch (PoolException e) {
             throw new  DAOException(e);
         }
     }
}
