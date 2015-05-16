package by.bsuir.gerasimovich.logic.command;

import by.bsuir.gerasimovich.controller.JspPageName;
import by.bsuir.gerasimovich.controller.RequestParameterName;
import by.bsuir.gerasimovich.dao.DAOException;
import by.bsuir.gerasimovich.dao.FactoryException;
import by.bsuir.gerasimovich.dao.mysql.MySqlCarBrandDao;
import by.bsuir.gerasimovich.dao.mysql.MySqlDaoFactory;
import by.bsuir.gerasimovich.entity.CarBrand;
import by.bsuir.gerasimovich.logic.CommandException;
import by.bsuir.gerasimovich.logic.ICommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Tatiana
 * @version 1.00 29.04.2015.
 */
public class OperationWithBrands implements ICommand {
    MySqlDaoFactory factory;
    MySqlCarBrandDao mySqlCarBrandDao;
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String page = null;
        String typeOfOperation = request.getParameter(RequestParameterName.TYPE_OF_OPERATION_WITH_BRAND);

        factory = MySqlDaoFactory.getInstance();
        try {
            mySqlCarBrandDao = (MySqlCarBrandDao) factory.getDao( CarBrand.class);

        if(typeOfOperation.equals(RequestParameterName.CREATE_BRAND)){
            String nameCarBrand = request.getParameter(RequestParameterName.NAME_OF_CAR_BRAND);
            CarBrand carBrand=new CarBrand(mySqlCarBrandDao.getNewId(),nameCarBrand.toUpperCase());
            mySqlCarBrandDao.persist(carBrand);
        }
        if(typeOfOperation.equals(RequestParameterName.UPDATE_BRAND)){
            String nameCarBrand = request.getParameter(RequestParameterName.NAME_OF_CAR_BRAND);
            String idCarBrand = request.getParameter(RequestParameterName.ID_OF_CAR_BRAND);
            CarBrand carBrand=new CarBrand(Integer.valueOf(idCarBrand),nameCarBrand.toUpperCase());
            mySqlCarBrandDao.update(carBrand);
        }
        if(typeOfOperation.equals(RequestParameterName.DELETE_BRAND)){
            String idCarBrand = request.getParameter(RequestParameterName.ID_OF_CAR_BRAND);
            CarBrand carBrand=new CarBrand(Integer.valueOf(idCarBrand),"");
            mySqlCarBrandDao.delete(carBrand);
        }
        request.setAttribute("all1", mySqlCarBrandDao.getAll());
        request.setAttribute("allBrand", mySqlCarBrandDao.getAll());
        page = JspPageName.OPERATION_WITH_BRANDS;
        return page;
        } catch (FactoryException e) {
            throw new CommandException(e);
    } catch (DAOException e) {
            throw new CommandException(e);
        }
    }
}