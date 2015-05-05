package by.bsuir.gerasimovich.logic.cammand;

import by.bsuir.gerasimovich.controller.JspPageName;
import by.bsuir.gerasimovich.controller.RequestParameterName;
import by.bsuir.gerasimovich.dao.PersistException;
import by.bsuir.gerasimovich.dao.mysql.MySqlDaoFactory;
import by.bsuir.gerasimovich.dao.mysql.MySqlSelectInAll;
import by.bsuir.gerasimovich.entity.SelectAll;
import by.bsuir.gerasimovich.logic.ICommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Tatiana
 * @version 1.00 26.04.2015.
 */
public class ListOfAllByBrand implements ICommand {
    MySqlDaoFactory factory;
    MySqlSelectInAll mySqlSelectInAll;
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws PersistException {
        String page = null;
        String filterType = request.getParameter(RequestParameterName.FILTER_TYPE);
        factory = MySqlDaoFactory.getInstance();
        mySqlSelectInAll = (MySqlSelectInAll) factory.getDao( SelectAll.class);
        request.setAttribute("all1",mySqlSelectInAll.getAllFilter("CarBrands.NameBrand", filterType));
        page = JspPageName.LIST_OF_ALL_BY_BRAND;
        return page;
    }
}
