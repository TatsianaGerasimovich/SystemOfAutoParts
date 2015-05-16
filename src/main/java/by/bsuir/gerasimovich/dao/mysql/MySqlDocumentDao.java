package by.bsuir.gerasimovich.dao.mysql;

import by.bsuir.gerasimovich.dao.AbstractJDBCDao;
import by.bsuir.gerasimovich.dao.DAOException;
import by.bsuir.gerasimovich.entity.Document;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Tatiana
 * @version 1.00 07.04.2015.
 */
public class MySqlDocumentDao extends AbstractJDBCDao<Document> {
    private final String SELECT = "SELECT documentId, agentId,documentType,date FROM Documents";
    private final String INSERT = "INSERT INTO Documents (documentId, agentId,documentType,date) \n"
            + "VALUES (?, ?, ?, ?);";
    private final String UPDATE = "UPDATE Documents SET agentId = ?, documentType = ?, date = ? WHERE documentId= ?;";
    private final String DELETE = "DELETE FROM Documents WHERE documentId= ?;";
    private static MySqlDocumentDao instance;

    public static MySqlDocumentDao getInstance() throws DAOException {
        if (instance == null) {
            synchronized (MySqlDocumentDao.class) {
                if (instance == null) {
                    instance = new MySqlDocumentDao();
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

     private MySqlDocumentDao() throws DAOException {
         super();

     }
    @Override
    protected List<Document> parseResultSet(ResultSet rs) throws DAOException {
        LinkedList<Document> result = new LinkedList<Document>();
        try {
            while (rs.next()) {
                Document order = new Document();
                order.setId(rs.getInt("documentId"));
                order.setAgentId(rs.getInt("agentId"));
                order.setDocumentType(rs.getString("documentType"));
                order.setDate(rs.getDate("date"));
                result.add(order);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return result;
    }

    public int getNewId() throws DAOException {
        List<Document> idCreate = null;
            idCreate = this.getAll();

        List<Integer> idCr = new ArrayList();
        for (Document item : idCreate) {
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
    protected void prepareStatementForInsert(PreparedStatement statement, Document object) throws DAOException {
        try {
            statement.setInt(1, object.getId());
            statement.setInt(2, object.getAgentId());
            statement.setString(3, object.getDocumentType());
            statement.setDate(4, object.getDate());

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Document object) throws DAOException {
        try {
            statement.setInt(1, object.getAgentId());
            statement.setString(2, object.getDocumentType());
            statement.setDate(3, object.getDate());
            statement.setInt(4, object.getId());

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
