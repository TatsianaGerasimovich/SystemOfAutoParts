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


    @Override
    public GenericDao getDao(Class entityClass) throws PersistException {
        DaoCreator creator = creators.get(entityClass);
        if (creator == null) {
            throw new PersistException("Dao object for " + entityClass + " not found.");
        }
        return creator.create();
    }

    public MySqlDaoFactory() {
        creators = new HashMap<Class,  DaoCreator>();
        creators.put(Contractor.class, new DaoCreator() {
            @Override
            public GenericDao create() {
                return new MySqlContractorDao();
            }
        });
        creators.put(Document.class, new DaoCreator() {
            @Override
            public GenericDao create() {
                return new MySqlDocumentDao();
            }
        });
        creators.put(CarBrand.class, new DaoCreator() {
            @Override
            public GenericDao create() {
                return new MySqlCarBrandDao();
            }
        });
        creators.put(AutoPart.class, new DaoCreator() {
            @Override
            public GenericDao create() {
                return new MySqlAutoPartDao();
            }
        });
        creators.put(AutoPart.AutoParts_has_CarModels.class, new DaoCreator() {
            @Override
            public GenericDao create() {
                return new MySqlAutoParts_has_CarModelsDao();
            }
        });
        creators.put(CarModel.class, new DaoCreator() {
            @Override
            public GenericDao create() {
                return new MySqlCarModelDao();
            }
        });
        creators.put(Documents_has_AutoParts.class, new DaoCreator() {
            @Override
            public GenericDao create() {
                return new MySqlDocuments_has_AutoPartsDao();
            }
        });
        creators.put(SelectAll.class, new DaoCreator() {
            @Override
            public GenericDao create() {
                return new MySqlSelectInAll();
            }
        });
    }
}
