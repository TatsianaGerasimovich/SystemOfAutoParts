package by.bsuir.gerasimovich.dao.mysql;

import by.bsuir.gerasimovich.dao.AbstractJDBCDao;
import by.bsuir.gerasimovich.dao.PersistException;
import by.bsuir.gerasimovich.entity.SelectAll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Tatiana
 * @version 1.00 12.04.2015.
 */
public class MySqlSelectInAll extends AbstractJDBCDao<SelectAll> {
    private final String SELECT = "SELECT AutoParts.AutoPartId, AutoParts.Name, CarBrands.NameBrand, CarModels.NameModel, "+
            "CarModels.YearOfRelease,Contractors.NameOfAgent, Documents_has_AutoParts.Price, Documents_has_AutoParts.Number FROM AutoParts\n"+
            "INNER JOIN AutoParts_has_CarModels  ON  AutoParts.AutoPartId=AutoParts_has_CarModels.AutoPartId \n"+
            "INNER JOIN CarModels  ON  AutoParts_has_CarModels.CarModelId=CarModels.CarModelId \n"+
            "INNER JOIN CarBrands  ON  CarModels.CarBrandId=CarBrands.CarBrandId\n"+
            "INNER JOIN Documents_has_AutoParts  ON  AutoParts.AutoPartId=Documents_has_AutoParts.AutoParts_AutoPartId\n"+
            "INNER JOIN Documents  ON  Documents_has_AutoParts.Documents_DocumentId=Documents.DocumentId\n"+
            "INNER JOIN Contractors  ON  Documents.AgentId=Contractors.AgentId";
    private final String SELECTSEARCH = "SELECT AutoParts.AutoPartId, AutoParts.Name, CarBrands.NameBrand, CarModels.NameModel, "+
            "CarModels.YearOfRelease,Contractors.NameOfAgent, Documents_has_AutoParts.Price, Documents_has_AutoParts.Number FROM AutoParts\n"+
            "INNER JOIN AutoParts_has_CarModels  ON  AutoParts.AutoPartId=AutoParts_has_CarModels.AutoPartId \n"+
            "INNER JOIN CarModels  ON  AutoParts_has_CarModels.CarModelId=CarModels.CarModelId \n"+
            "INNER JOIN CarBrands  ON  CarModels.CarBrandId=CarBrands.CarBrandId\n"+
            "INNER JOIN Documents_has_AutoParts  ON  AutoParts.AutoPartId=Documents_has_AutoParts.AutoParts_AutoPartId\n"+
            "INNER JOIN Documents  ON  Documents_has_AutoParts.Documents_DocumentId=Documents.DocumentId\n"+
            "INNER JOIN Contractors  ON  Documents.AgentId=Contractors.AgentId\n";
    private final String SELECTSORT = "SELECT AutoParts.AutoPartId, AutoParts.Name, CarBrands.NameBrand, CarModels.NameModel, "+
            "CarModels.YearOfRelease,Contractors.NameOfAgent, Documents_has_AutoParts.Price, Documents_has_AutoParts.Number FROM AutoParts\n"+
            "INNER JOIN AutoParts_has_CarModels  ON  AutoParts.AutoPartId=AutoParts_has_CarModels.AutoPartId \n"+
            "INNER JOIN CarModels  ON  AutoParts_has_CarModels.CarModelId=CarModels.CarModelId \n"+
            "INNER JOIN CarBrands  ON  CarModels.CarBrandId=CarBrands.CarBrandId\n"+
            "INNER JOIN Documents_has_AutoParts  ON  AutoParts.AutoPartId=Documents_has_AutoParts.AutoParts_AutoPartId\n"+
            "INNER JOIN Documents  ON  Documents_has_AutoParts.Documents_DocumentId=Documents.DocumentId\n"+
            "INNER JOIN Contractors  ON  Documents.AgentId=Contractors.AgentId\n"+
            "ORDER BY ? ASC";
    //!!!!!!!!!!!!!
    private final String SELECTSCARCE = "SELECT AutoParts.AutoPartId, AutoParts.Name, CarBrands.NameBrand, CarModels.NameModel, "+
            "CarModels.YearOfRelease,Contractors.NameOfAgent, Documents_has_AutoParts.Price,SUM( Documents_has_AutoParts.Number) FROM AutoParts\n"+
            "INNER JOIN AutoParts_has_CarModels  ON  AutoParts.AutoPartId=AutoParts_has_CarModels.AutoPartId \n"+
            "INNER JOIN CarModels  ON  AutoParts_has_CarModels.CarModelId=CarModels.CarModelId \n"+
            "INNER JOIN CarBrands  ON  CarModels.CarBrandId=CarBrands.CarBrandId\n"+
            "INNER JOIN Documents_has_AutoParts  ON  AutoParts.AutoPartId=Documents_has_AutoParts.AutoParts_AutoPartId\n"+
            "INNER JOIN Documents  ON  Documents_has_AutoParts.Documents_DocumentId=Documents.DocumentId\n"+
            "INNER JOIN Contractors  ON  Documents.AgentId=Contractors.AgentId\n"+
            "GROUP BY AutoParts.AutoPartId\n"+
            "HAVING  SUM( Documents_has_AutoParts.Number)<3";
    private static MySqlSelectInAll instance;

    public static MySqlSelectInAll getInstance() {
        if (instance == null) {
            synchronized (MySqlSelectInAll.class) {
                if (instance == null) {
                    instance = new MySqlSelectInAll();
                }
            }
        }
        return instance;
    }


    @Override
    public String getSelectQuery() {
        return null;
    }

    @Override
    public String getCreateQuery() {
        return null;
    }

    @Override
    public String getUpdateQuery() {return null; }

    @Override
    public String getDeleteQuery() {
        return null;
    }

    private MySqlSelectInAll() {

    }
    @Override
    protected List<SelectAll> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<SelectAll> result = new LinkedList<SelectAll>();
        try {
            while (rs.next()) {
                SelectAll selectAll = new SelectAll();
                selectAll.setId(rs.getInt("AutoPartId"));
                selectAll.setName(rs.getString("Name"));
                selectAll.setNameBrand(rs.getString("NameBrand"));
                selectAll.setNameModel(rs.getString("NameModel"));
                selectAll.setYearOfRelease(rs.getInt("YearOfRelease"));
                selectAll.setNameOfAgent(rs.getString("NameOfAgent"));
                selectAll.setPrice(rs.getInt("Price"));
                selectAll.setNumber(rs.getInt("Number"));
                result.add(selectAll);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
    }
    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, SelectAll object) throws PersistException {
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, SelectAll object) throws PersistException {
    }

    public List<SelectAll> getAll() throws PersistException {
        List<SelectAll> list;
        String sql = SELECT;
        ResultSet rs=null;
        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
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
                //ignore
            }
            try {
                putConnection();
            } catch (PersistException e) {
                throw new  PersistException(e);
            }
        }
        return list;
    }

    public List<SelectAll> getAllFilter(String where, String what) throws PersistException {
        List<SelectAll> list;
        ResultSet rs=null;
        String sql = SELECTSEARCH+
                "WHERE " + where + " = ?";

        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
                 try {
                    statement.setString(1, what);
                } catch (Exception e) {
                    throw new PersistException(e);
                }

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
                putConnection();
            } catch (PersistException e) {
                throw new  PersistException(e);
            }
        }
        return list;
    }

    public List<SelectAll> getAllSort(String sort) throws PersistException {
        List<SelectAll> list;
        ResultSet rs=null;
        String sql = SELECTSORT;
        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            try {
                System.out.println("Sort in dao: "+sort);
                statement.setString(1, sort);
                System.out.println( sql);
            } catch (Exception e) {
                throw new PersistException(e);
            }
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
                putConnection();
            } catch (PersistException e) {
                throw new  PersistException(e);
            }
        }
        return list;
    }
    public List<SelectAll> getAllScarce() throws PersistException {
        List<SelectAll> list;
        String sql = SELECTSCARCE;
       // sql+="\n"+"WHERE Documents_has_AutoParts.Number < 3\n";
        ResultSet rs=null;
        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
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
                putConnection();
            } catch (PersistException e) {
                throw new  PersistException(e);
            }
        }
        return list;
    }
}
