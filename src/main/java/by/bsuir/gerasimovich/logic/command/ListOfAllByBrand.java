package by.bsuir.gerasimovich.logic.command;

import by.bsuir.gerasimovich.controller.JspPageName;
import by.bsuir.gerasimovich.controller.RequestParameterName;
import by.bsuir.gerasimovich.dao.DAOException;
import by.bsuir.gerasimovich.dao.FactoryException;
import by.bsuir.gerasimovich.dao.mysql.MySqlDaoFactory;
import by.bsuir.gerasimovich.dao.mysql.MySqlSelectInAll;
import by.bsuir.gerasimovich.entity.SelectAll;
import by.bsuir.gerasimovich.logic.CommandException;
import by.bsuir.gerasimovich.logic.ICommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Tatiana
 * @version 1.00 26.04.2015.
 */
public class ListOfAllByBrand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        MySqlDaoFactory factory;
        MySqlSelectInAll mySqlSelectInAll;
        String page = null;
        String filterType = request.getParameter(RequestParameterName.FILTER_TYPE);
        factory = MySqlDaoFactory.getInstance();
        try {
            mySqlSelectInAll = (MySqlSelectInAll) factory.getDao( SelectAll.class);

        request.setAttribute("all1",mySqlSelectInAll.getAllFilter("CarBrands.NameBrand", filterType));
        page = JspPageName.LIST_OF_ALL_BY_BRAND;
        return page;
        } catch (FactoryException e) {
            throw new CommandException(e);
        } catch (DAOException e) {
            throw new CommandException(e);
        }
    }
}
