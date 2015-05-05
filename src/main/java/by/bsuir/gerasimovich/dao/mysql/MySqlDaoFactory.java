package by.bsuir.gerasimovich.dao.mysql;

import by.bsuir.gerasimovich.entity.*;
import by.bsuir.gerasimovich.dao.DaoFactory;
import by.bsuir.gerasimovich.dao.GenericDao;
import by.bsuir.gerasimovich.dao.PersistException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Tatiana
 * @version 1.00 07.04.2015.
 */

public class MySqlDaoFactory implements DaoFactory {

    public interface DaoCreator {

        public GenericDao create();
    }

    private Map<Class, DaoCreator> creators;
    private static MySqlDaoFactory instance;

    public static MySqlDaoFactory getInstance() {
        if (instance == null) {
            synchronized (MySqlDaoFactory.class) {
                if (instance == null) {
                    instance = new MySqlDaoFactory();
                }
            }
        }
        return instance;
    }

    @Override
    public GenericDao getDao(Class entityClass) throws PersistException {
        DaoCreator creator = creators.get(entityClass);
        if (creator == null) {
            throw new PersistException("Dao object for " + entityClass + " not found.");
        }
        return creator.create();
    }

    private MySqlDaoFactory() {
        creators = new HashMap<Class,  DaoCreator>();
        creators.put(Contractor.class, new DaoCreator() {
            @Override
            public GenericDao create() {
                return  MySqlContractorDao.getInstance();
            }
        });
        creators.put(Document.class, new DaoCreator() {
            @Override
            public GenericDao create() {
                return MySqlDocumentDao.getInstance();
            }
        });
        creators.put(CarBrand.class, new DaoCreator() {
            @Override
            public GenericDao create() {
                return  MySqlCarBrandDao.getInstance();
            }
        });
        creators.put(AutoPart.class, new DaoCreator() {
            @Override
            public GenericDao create() {
                return  MySqlAutoPartDao.getInstance();
            }
        });
        creators.put(AutoParts_has_CarModels.class, new DaoCreator() {
            @Override
            public GenericDao create() {
                return  MySqlAutoParts_has_CarModelsDao.getInstance();
            }
        });
        creators.put(CarModel.class, new DaoCreator() {
            @Override
            public GenericDao create() {
                return MySqlCarModelDao.getInstance();
            }
        });
        creators.put(Documents_has_AutoParts.class, new DaoCreator() {
            @Override
            public GenericDao create() {
                return MySqlDocuments_has_AutoPartsDao.getInstance();
            }
        });
        creators.put(SelectAll.class, new DaoCreator() {
            @Override
            public GenericDao create() {
                return MySqlSelectInAll.getInstance();
            }
        });
    }
}
