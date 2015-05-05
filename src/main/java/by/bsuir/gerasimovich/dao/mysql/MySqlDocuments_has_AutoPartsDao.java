package by.bsuir.gerasimovich.dao.mysql;

import by.bsuir.gerasimovich.dao.AbstractJDBCDao;
import by.bsuir.gerasimovich.dao.PersistException;
import by.bsuir.gerasimovich.entity.Documents_has_AutoParts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Tatiana
 * @version 1.00 12.04.2015.
 */
public class MySqlDocuments_has_AutoPartsDao extends AbstractJDBCDao<Documents_has_AutoParts> {

    private final String SELECT = "SELECT autoParts_autoPartId, documents_DocumentId,Price,Number,Currency FROM Documents_has_AutoParts";
    private final String INSERT = "INSERT INTO Documents_has_AutoParts (autoParts_autoPartId, documents_DocumentId,Price,Number,Currency) \n"
            + "VALUES (?, ?, ?, ?, ?);";
    private final String UPDATE = "UPDATE Documents_has_AutoParts SET autoParts_autoPartId = ? Price=? Number=? Currency=? WHERE documents_DocumentId= ?;";
    private final String DELETE = "DELETE FROM Documents_has_AutoParts WHERE autoParts_autoPartId = ?;";
    private static MySqlDocuments_has_AutoPartsDao instance;

    public static MySqlDocuments_has_AutoPartsDao getInstance() {
        if (instance == null) {
            synchronized (MySqlDocuments_has_AutoPartsDao.class) {
                if (instance == null) {
                    instance = new MySqlDocuments_has_AutoPartsDao();
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

    private MySqlDocuments_has_AutoPartsDao() {

    }

    @Override
    protected List<Documents_has_AutoParts> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<Documents_has_AutoParts> result = new LinkedList<Documents_has_AutoParts>();
        try {
            while (rs.next()) {
                Documents_has_AutoParts part = new Documents_has_AutoParts();
                part.setId(rs.getInt("autoParts_autoPartId"));
                part.setDocumentId(rs.getInt("documents_DocumentId"));
                result.add(part);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Documents_has_AutoParts object) throws PersistException {
        try {
            statement.setInt(1, object.getId());
            statement.setInt(2, object.getDocumentId());
            statement.setInt(3, object.getPrice());
            statement.setInt(4, object.getNumber());
            statement.setString(5, object.getCurrency());

        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Documents_has_AutoParts object) throws PersistException {
        try {
            statement.setInt(1, object.getId());
            statement.setInt(2, object.getPrice());
            statement.setInt(3, object.getNumber());
            statement.setString(4, object.getCurrency());
            statement.setInt(5, object.getDocumentId());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }
}
