package by.bsuir.gerasimovich.dao.mysql;

import by.bsuir.gerasimovich.dao.AbstractJDBCDao;
import by.bsuir.gerasimovich.dao.DAOException;
import by.bsuir.gerasimovich.entity.SelectAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 * @author Tatiana
 * @version 1.00 12.04.2015.
 */
public class MySqlSelectInAll extends AbstractJDBCDao<SelectAll> {
    private final String SELECT = "SELECT AutoParts.AutoPartId, AutoParts.Name, CarBrands.NameBrand, CarModels.NameModel, "+
            "CarModels.YearOfRelease,Contractors.NameOfAgent, Documents_has_AutoParts.Price,Documents_has_AutoParts.Currency, Documents_has_AutoParts.Number FROM AutoParts\n"+
            "INNER JOIN AutoParts_has_CarModels  ON  AutoParts.AutoPartId=AutoParts_has_CarModels.AutoPartId \n"+
            "INNER JOIN CarModels  ON  AutoParts_has_CarModels.CarModelId=CarModels.CarModelId \n"+
            "INNER JOIN CarBrands  ON  CarModels.CarBrandId=CarBrands.CarBrandId\n"+
            "INNER JOIN Documents_has_AutoParts  ON  AutoParts.AutoPartId=Documents_has_AutoParts.AutoParts_AutoPartId\n"+
            "INNER JOIN Documents  ON  Documents_has_AutoParts.Documents_DocumentId=Documents.DocumentId\n"+
            "INNER JOIN Contractors  ON  Documents.AgentId=Contractors.AgentId";
    private final String SELECTSEARCH = "SELECT AutoParts.AutoPartId, AutoParts.Name, CarBrands.NameBrand, CarModels.NameModel, "+
            "CarModels.YearOfRelease,Contractors.NameOfAgent, Documents_has_AutoParts.Price,Documents_has_AutoParts.Currency, Documents_has_AutoParts.Number FROM AutoParts\n"+
            "INNER JOIN AutoParts_has_CarModels  ON  AutoParts.AutoPartId=AutoParts_has_CarModels.AutoPartId \n"+
            "INNER JOIN CarModels  ON  AutoParts_has_CarModels.CarModelId=CarModels.CarModelId \n"+
            "INNER JOIN CarBrands  ON  CarModels.CarBrandId=CarBrands.CarBrandId\n"+
            "INNER JOIN Documents_has_AutoParts  ON  AutoParts.AutoPartId=Documents_has_AutoParts.AutoParts_AutoPartId\n"+
            "INNER JOIN Documents  ON  Documents_has_AutoParts.Documents_DocumentId=Documents.DocumentId\n"+
            "INNER JOIN Contractors  ON  Documents.AgentId=Contractors.AgentId\n";
    private final String SELECTSORT = "SELECT AutoParts.AutoPartId, AutoParts.Name, CarBrands.NameBrand, CarModels.NameModel, "+
            "CarModels.YearOfRelease,Contractors.NameOfAgent, Documents_has_AutoParts.Price,Documents_has_AutoParts.Currency, Documents_has_AutoParts.Number FROM AutoParts\n"+
            "INNER JOIN AutoParts_has_CarModels  ON  AutoParts.AutoPartId=AutoParts_has_CarModels.AutoPartId \n"+
            "INNER JOIN CarModels  ON  AutoParts_has_CarModels.CarModelId=CarModels.CarModelId \n"+
            "INNER JOIN CarBrands  ON  CarModels.CarBrandId=CarBrands.CarBrandId\n"+
            "INNER JOIN Documents_has_AutoParts  ON  AutoParts.AutoPartId=Documents_has_AutoParts.AutoParts_AutoPartId\n"+
            "INNER JOIN Documents  ON  Documents_has_AutoParts.Documents_DocumentId=Documents.DocumentId\n"+
            "INNER JOIN Contractors  ON  Documents.AgentId=Contractors.AgentId\n"+
            "ORDER BY ";
    private final String SELECTSCARCE = "SELECT AutoParts.AutoPartId, AutoParts.Name, CarBrands.NameBrand, CarModels.NameModel, "+
            "CarModels.YearOfRelease,Contractors.NameOfAgent, Documents_has_AutoParts.Price,Documents_has_AutoParts.Currency,SUM( Documents_has_AutoParts.Number) AS Number FROM AutoParts\n"+
            "INNER JOIN AutoParts_has_CarModels  ON  AutoParts.AutoPartId=AutoParts_has_CarModels.AutoPartId \n"+
            "INNER JOIN CarModels  ON  AutoParts_has_CarModels.CarModelId=CarModels.CarModelId \n"+
            "INNER JOIN CarBrands  ON  CarModels.CarBrandId=CarBrands.CarBrandId\n"+
            "INNER JOIN Documents_has_AutoParts  ON  AutoParts.AutoPartId=Documents_has_AutoParts.AutoParts_AutoPartId\n"+
            "INNER JOIN Documents  ON  Documents_has_AutoParts.Documents_DocumentId=Documents.DocumentId\n"+
            "INNER JOIN Contractors  ON  Documents.AgentId=Contractors.AgentId\n"+
            "GROUP BY AutoParts.AutoPartId\n"+
            "HAVING  SUM( Documents_has_AutoParts.Number)<10";
    private static MySqlSelectInAll instance;

    public static MySqlSelectInAll getInstance() throws DAOException {
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

    private MySqlSelectInAll() throws DAOException {
        super();

    }
    @Override
    protected List<SelectAll> parseResultSet(ResultSet rs) throws DAOException {
       // LinkedList<SelectAll> result = new LinkedList<SelectAll>();
        List<SelectAll> result = new ArrayList<>();
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
                selectAll.setCurrency(rs.getString("Currency"));
                result.add(selectAll);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return result;
    }
    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, SelectAll object) throws DAOException {
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, SelectAll object) throws DAOException {
    }

    public List<SelectAll> getAll() throws DAOException {
        List<SelectAll> list;
        String sql = SELECT;
        ResultSet rs=null;
        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            rs = statement.executeQuery();
            list = parseResultSet(rs);
            FileInputStream fis;
            Properties property = new Properties();
            int usd;
            int rub;
            int eur;
            try {
                fis = new FileInputStream("D:\\Work\\idea\\SystemOfAutoparts\\src\\main\\resources\\exchangeRates.properties");
                property.load(fis);

                usd = Integer.parseInt(property.getProperty("USD"));
                rub = Integer.parseInt(property.getProperty("RUB"));
                eur = Integer.parseInt(property.getProperty("EUR"));

            } catch (IOException e) {
                throw new DAOException("Properties file is not found",e);
            }
            for(SelectAll obj:list){
                if(obj.getCurrency().equals("USD")) {
                    obj.setPrice(obj.getPrice() * usd);
                    obj.setCurrency("BYR");
                }
                if(obj.getCurrency().equals("RUB")) {
                    obj.setPrice(obj.getPrice() * rub);
                    obj.setCurrency("BYR");
                }
                if(obj.getCurrency().equals("EUR")) {
                    obj.setPrice(obj.getPrice() * eur);
                    obj.setCurrency("BYR");
                }
            }
            statement.close();
        } catch (SQLException e) {
            throw new DAOException(e);
        }finally {
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                //ignore
            }
                putConnection();

        }
        return list;
    }

    public List<SelectAll> getAllFilter(String where, String what) throws DAOException {
        List<SelectAll> list;
        ResultSet rs=null;
        String sql = SELECTSEARCH+
                "WHERE " + where + " = ?";

        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
                 try {
                    statement.setString(1, what);
                } catch (SQLException e) {
                    throw new DAOException(e);
                }

            rs = statement.executeQuery();
            list = parseResultSet(rs);
            FileInputStream fis;
            Properties property = new Properties();
            int usd;
            int rub;
            int eur;
            try {
                fis = new FileInputStream("D:\\Work\\idea\\SystemOfAutoparts\\src\\main\\resources\\exchangeRates.properties");
                property.load(fis);

                usd = Integer.parseInt(property.getProperty("USD"));
                rub = Integer.parseInt(property.getProperty("RUB"));
                eur = Integer.parseInt(property.getProperty("EUR"));


            } catch (IOException e) {
                throw new DAOException("Properties file is not found",e);
            }
            for(SelectAll obj:list){
                if(obj.getCurrency().equals("USD")) {
                    obj.setPrice(obj.getPrice() * usd);
                    obj.setCurrency("BYR");
                }
                if(obj.getCurrency().equals("RUB")) {
                    obj.setPrice(obj.getPrice() * rub);
                    obj.setCurrency("BYR");
                }
                if(obj.getCurrency().equals("EUR")) {
                    obj.setPrice(obj.getPrice() * eur);
                    obj.setCurrency("BYR");
                }
            }
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
                putConnection();

        }
        return list;
    }

    public List<SelectAll> getAllSort(String sort) throws DAOException {
        List<SelectAll> list;
        ResultSet rs=null;
        String sql = SELECTSORT;
        sql+=sort;
        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            rs = statement.executeQuery();
            list = parseResultSet(rs);
            FileInputStream fis;
            Properties property = new Properties();
            int usd;
            int rub;
            int eur;
            try {
                fis = new FileInputStream("D:\\Work\\idea\\SystemOfAutoparts\\src\\main\\resources\\exchangeRates.properties");
                property.load(fis);

                usd = Integer.parseInt(property.getProperty("USD"));
                rub = Integer.parseInt(property.getProperty("RUB"));
                eur = Integer.parseInt(property.getProperty("EUR"));

            } catch (IOException e) {
                throw new DAOException("Properties file is not found",e);
            }
            for(SelectAll obj:list){
                if(obj.getCurrency().equals("USD")) {
                    obj.setPrice(obj.getPrice() * usd);
                    obj.setCurrency("BYR");
                }
                if(obj.getCurrency().equals("RUB")) {
                    obj.setPrice(obj.getPrice() * rub);
                    obj.setCurrency("BYR");
                }
                if(obj.getCurrency().equals("EUR")) {
                    obj.setPrice(obj.getPrice() * eur);
                    obj.setCurrency("BYR");
                }
            }
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
                putConnection();

        }
        return list;
    }
    public List<SelectAll> getAllScarce() throws DAOException {
        List<SelectAll> list;
        String sql = SELECTSCARCE;
       // sql+="\n"+"WHERE Documents_has_AutoParts.Number < 3\n";
        ResultSet rs=null;
        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
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
                putConnection();

        }
        return list;
    }
}
