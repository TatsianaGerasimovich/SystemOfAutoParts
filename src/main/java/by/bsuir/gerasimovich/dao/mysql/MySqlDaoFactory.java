package by.bsuir.gerasimovich.dao.mysql;

import by.bsuir.gerasimovich.dao.DAOException;
import by.bsuir.gerasimovich.dao.FactoryException;
import by.bsuir.gerasimovich.entity.*;
import by.bsuir.gerasimovich.dao.DaoFactory;
import by.bsuir.gerasimovich.dao.GenericDao;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tatiana
 * @version 1.00 07.04.2015.
 */

public class MySqlDaoFactory implements DaoFactory {

    public interface DaoCreator {

        public GenericDao create() throws FactoryException;
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
    public GenericDao getDao(Class entityClass) throws FactoryException {
        DaoCreator creator = creators.get(entityClass);
        if (creator == null) {
            throw new FactoryException("Dao object for " + entityClass + " not found.");
        }
        return creator.create();
    }

    private MySqlDaoFactory() {
        creators = new HashMap<Class,  DaoCreator>();
        creators.put(Contractor.class, new DaoCreator() {
            @Override
            public GenericDao create() throws FactoryException {
                try {
                    return  MySqlContractorDao.getInstance();
                } catch (DAOException e) {
                    throw new FactoryException(e);
                }
            }
        });
        creators.put(Document.class, new DaoCreator() {
            @Override
            public GenericDao create() throws FactoryException {
                try {
                    return MySqlDocumentDao.getInstance();
                } catch (DAOException e) {
                    throw new FactoryException(e);
                }
            }
        });
        creators.put(CarBrand.class, new DaoCreator() {
            @Override
            public GenericDao create()throws FactoryException {
                try {
                    return  MySqlCarBrandDao.getInstance();
                } catch (DAOException e) {
                    throw new FactoryException(e);
                }
            }
        });
        creators.put(AutoPart.class, new DaoCreator() {
            @Override
            public GenericDao create() throws FactoryException {
                try {
                    return  MySqlAutoPartDao.getInstance();
                } catch (DAOException e) {
                    throw new FactoryException(e);
                }
            }
        });
        creators.put(AutoParts_has_CarModels.class, new DaoCreator() {
            @Override
            public GenericDao create() throws FactoryException{
                try {
                    return  MySqlAutoParts_has_CarModelsDao.getInstance();
                } catch (DAOException e) {
                    throw new FactoryException(e);
                }
            }
        });
        creators.put(CarModel.class, new DaoCreator() {
            @Override
            public GenericDao create() throws FactoryException {
                try {
                    return MySqlCarModelDao.getInstance();
                } catch (DAOException e) {
                    throw new FactoryException(e);
                }
            }
        });
        creators.put(Documents_has_AutoParts.class, new DaoCreator() {
            @Override
            public GenericDao create()throws FactoryException {
                try {
                    return MySqlDocuments_has_AutoPartsDao.getInstance();
                } catch (DAOException e) {
                    throw new FactoryException(e);
                }
            }
        });
        creators.put(SelectAll.class, new DaoCreator() {
            @Override
            public GenericDao create() throws FactoryException{
                try {
                    return MySqlSelectInAll.getInstance();
                } catch (DAOException e) {
                    throw new FactoryException(e);
                }
            }
        });
    }
}
