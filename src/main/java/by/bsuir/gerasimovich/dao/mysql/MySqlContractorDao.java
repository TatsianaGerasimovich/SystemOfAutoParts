package by.bsuir.gerasimovich.dao.mysql;

/**
 * @author Tatiana
 * @version 1.00 07.04.2015.
 */
import by.bsuir.gerasimovich.dao.AbstractJDBCDao;
import by.bsuir.gerasimovich.dao.DAOException;
import by.bsuir.gerasimovich.entity.Contractor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MySqlContractorDao extends AbstractJDBCDao<Contractor> {
    private final String SELECT = "SELECT agentId, nameOfAgent,address,phone,typeOfAgent,rating FROM Contractors";
    private final String INSERT = "INSERT INTO Contractors (agentId, nameOfAgent,address,phone,typeOfAgent,rating) \n"
            + "VALUES (?, ?, ?, ?, ?, ?);";
    private final String UPDATE = "UPDATE Contractors SET nameOfAgent = ?, address = ?, phone = ?, typeOfAgent = ?, rating = ? WHERE agentId= ?;";
    private final String DELETE = "DELETE FROM Contractors WHERE agentId= ?;";
    private static MySqlContractorDao instance;

    public static MySqlContractorDao getInstance() throws DAOException {
        if (instance == null) {
            synchronized (MySqlContractorDao.class) {
                if (instance == null) {
                    instance = new MySqlContractorDao();
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
        return  DELETE;
    }

    private MySqlContractorDao() throws DAOException {
        super();

    }
    @Override
    protected List<Contractor> parseResultSet(ResultSet rs) throws DAOException {
        LinkedList<Contractor> result = new LinkedList<Contractor>();
        try {
            while (rs.next()) {
                Contractor contractor = new Contractor();
                contractor.setId(rs.getInt("agentId"));
                contractor.setNameOfAgent(rs.getString("nameOfAgent"));
                contractor.setAddress(rs.getString("address"));
                contractor.setPhone(rs.getLong("phone"));
                contractor.setTypeOfAgent(rs.getString("typeOfAgent"));
                contractor.setRating(rs.getInt("rating"));
                
                result.add(contractor);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return result;
    }

    public int getNewId() throws DAOException {
        List<Contractor> idCreate = null;
        idCreate = this.getAll();
        List<Integer> idCr = new ArrayList();
        for (Contractor item : idCreate) {
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
    protected void prepareStatementForInsert(PreparedStatement statement, Contractor object) throws DAOException {
        try {
            statement.setInt(1, object.getId());
            statement.setString(2, object.getNameOfAgent());
            statement.setString(3, object.getAddress());
            statement.setLong(4, object.getPhone());
            statement.setString(5, object.getTypeOfAgent());
            statement.setInt(6, object.getRating());

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Contractor object) throws DAOException {
        try {
            statement.setString(1, object.getNameOfAgent());
            statement.setString(2, object.getAddress());
            statement.setLong(3, object.getPhone());
            statement.setString(4, object.getTypeOfAgent());
            statement.setInt(5, object.getRating());
            statement.setInt(6, object.getId());
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
