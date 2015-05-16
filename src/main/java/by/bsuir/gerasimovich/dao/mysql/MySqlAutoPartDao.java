package by.bsuir.gerasimovich.dao.mysql;

import by.bsuir.gerasimovich.dao.AbstractJDBCDao;
import by.bsuir.gerasimovich.dao.DAOException;
import by.bsuir.gerasimovich.entity.AutoPart;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Tatiana
 * @version 1.00 12.04.2015.
 */
public class MySqlAutoPartDao extends AbstractJDBCDao<AutoPart> {

    private final String SELECT = "SELECT AutoPartId, Name FROM autoparts";
    private final String INSERT = "INSERT INTO autoparts (AutoPartId, Name) \n"
            + "VALUES (?, ?);";
    private final String UPDATE = "UPDATE autoparts SET Name = ? WHERE AutoPartId= ?;";
    private final String DELETE = "DELETE FROM autoparts WHERE AutoPartId = ?;";
    private static MySqlAutoPartDao instance;

    public static MySqlAutoPartDao getInstance() throws DAOException {
        if (instance == null) {
            synchronized (MySqlAutoPartDao.class) {
                if (instance == null) {
                        instance = new MySqlAutoPartDao();
                }
            }
        }
        return instance;
    }

    @Override
    public String getSelectQuery() {
        return SELECT;
    }

    @Override
    public String getCreateQuery() {
        return INSERT;
    }

    @Override
    public String getUpdateQuery() {

        return UPDATE;
    }

    @Override
    public String getDeleteQuery() {
        return DELETE;
    }

    private MySqlAutoPartDao() throws DAOException {
        super();

    }

    @Override
    protected List<AutoPart> parseResultSet(ResultSet rs) throws DAOException {
        LinkedList<AutoPart> result = new LinkedList<AutoPart>();
        try {
            while (rs.next()) {
                AutoPart autoPart = new AutoPart();
                autoPart.setId(rs.getInt("AutoPartId"));
                autoPart.setName(rs.getString("Name"));
                result.add(autoPart);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return result;
    }

    public int getNewId() throws DAOException {
        List<AutoPart> idCreate = null;

            idCreate = this.getAll();

        List<Integer> idCr = new ArrayList();
        for (AutoPart item : idCreate) {
            idCr.add(item.getId());
        }
        Collections.sort(idCr);
        int mId = 0;
        if (idCreate != null) {
            for (Integer counter : idCr) {
                mId = counter;
            }
        }
        return ++mId;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, AutoPart object) throws DAOException {
        try {
            statement.setInt(1, object.getId());
            statement.setString(2, object.getName());

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, AutoPart object) throws DAOException {
        try {
            statement.setString(1, object.getName());
            statement.setInt(2, object.getId());
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}