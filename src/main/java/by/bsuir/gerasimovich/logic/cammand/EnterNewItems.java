package by.bsuir.gerasimovich.logic.cammand;

import by.bsuir.gerasimovich.controller.JspPageName;
import by.bsuir.gerasimovich.controller.RequestParameterName;
import by.bsuir.gerasimovich.dao.PersistException;
import by.bsuir.gerasimovich.dao.mysql.MySqlAutoPartDao;
import by.bsuir.gerasimovich.dao.mysql.MySqlCarBrandDao;
import by.bsuir.gerasimovich.dao.mysql.MySqlContractorDao;
import by.bsuir.gerasimovich.dao.mysql.MySqlDaoFactory;
import by.bsuir.gerasimovich.entity.AutoPart;
import by.bsuir.gerasimovich.entity.CarBrand;
import by.bsuir.gerasimovich.entity.Contractor;
import by.bsuir.gerasimovich.logic.ICommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tatiana
 * @version 1.00 02.05.2015.
 */
public class EnterNewItems implements ICommand {
    MySqlDaoFactory factory;
    MySqlContractorDao mySqlContractorDao;
    MySqlAutoPartDao mySqlAutoPartDao;
    MySqlCarBrandDao mySqlCarBrandDao;
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws PersistException,SQLException {
        String page = null;
        String typeOfOperation = request.getParameter(RequestParameterName.TYPE_OF_ENTER_NEW_AUTO_PARTS);

        factory = new MySqlDaoFactory();
        mySqlContractorDao = (MySqlContractorDao) factory.getDao( Contractor.class);
        mySqlAutoPartDao=(MySqlAutoPartDao) factory.getDao(AutoPart.class);
        mySqlCarBrandDao = (MySqlCarBrandDao) factory.getDao( CarBrand.class);

        request.setAttribute("allAutoParts", mySqlAutoPartDao.getAll());
        request.setAttribute("allBrand", mySqlCarBrandDao.getAll());
        request.setAttribute("allAgent", mySqlContractorDao.getAll());
        page = JspPageName.ENTER_NEW_ITEMS;
        return page;
    }
}