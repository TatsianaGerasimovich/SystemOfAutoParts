package by.bsuir.gerasimovich.dao.mysql;

import by.bsuir.gerasimovich.dao.AbstractJDBCDao;
import by.bsuir.gerasimovich.dao.DAOException;
import by.bsuir.gerasimovich.entity.CarModel;

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
public class MySqlCarModelDao extends AbstractJDBCDao<CarModel> {

    private final String SELECT = "SELECT carModelId, carBrandId,nameModel,yearOfRelease FROM CarModels";
    private final String INSERT = "INSERT INTO CarModels (carModelId, carBrandId,nameModel,yearOfRelease) \n"
            + "VALUES (?, ?, ?, ?);";
    private final String UPDATE = "UPDATE CarModels SET nameModel = ?, yearOfRelease = ? WHERE carModelId =? AND carBrandId = ?;";
    private final String DELETE = "DELETE FROM CarModels WHERE carModelId= ? AND carBrandId = ?;";
    private static MySqlCarModelDao instance;

    public static MySqlCarModelDao getInstance() throws DAOException {
        if (instance == null) {
            synchronized (MySqlCarModelDao.class) {
                if (instance == null) {
                    instance = new MySqlCarModelDao();
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

    private MySqlCarModelDao() throws DAOException {
        super();

    }
    @Override
    protected List<CarModel> parseResultSet(ResultSet rs) throws DAOException {
        List<CarModel> result = new LinkedList<>();
        try {
            while (rs.next()) {
                CarModel carModel = new CarModel();
                carModel.setId(rs.getInt("CarModelId"));
                carModel.setCarBrandId(rs.getInt("carBrandId"));
                carModel.setNameModel (rs.getString("NameModel"));
                carModel.setYearOfRelease(rs.getInt("YearOfRelease"));
                result.add(carModel);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return result;
    }

    public int getNewId() throws DAOException {
        List<CarModel> idCreate = null;
            idCreate = this.getAll();

        List<Integer> idCr = new ArrayList();
        for (CarModel item : idCreate) {
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
    protected void prepareStatementForInsert(PreparedStatement statement, CarModel object) throws DAOException {
        try {
            statement.setInt(1, object.getId());
            statement.setInt(2, object.getCarBrandId());
            statement.setString (3, object.getNameModel());
            statement.setInt(4,object.getYearOfRelease());
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, CarModel object) throws DAOException {
        try {
            statement.setString (1, object.getNameModel());
            statement.setInt(2,object.getYearOfRelease());
            statement.setInt(3, object.getId());
            statement.setInt(4, object.getCarBrandId());
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    @Override
    public void delete(CarModel object) throws DAOException {
        String sql = getDeleteQuery();
        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            try {
                    statement.setInt(1, object.getId());
                    statement.setInt(2, object.getCarBrandId());

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
             putConnection();
        }
    }
}
