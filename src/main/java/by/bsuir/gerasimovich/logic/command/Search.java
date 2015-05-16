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
 * @version 1.00 27.04.2015.
 */
public class Search implements ICommand {
    MySqlDaoFactory factory;
    MySqlSelectInAll mySqlSelectInAll;
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String page = null;
        String whereSearch = request.getParameter(RequestParameterName.WHERE_SEARCH);
        String whatSearch = request.getParameter(RequestParameterName.WHAT_SEARCH);
        factory = MySqlDaoFactory.getInstance();
        try {
            mySqlSelectInAll = (MySqlSelectInAll) factory.getDao( SelectAll.class);

        if(whereSearch.equals("notSearch")) {
            request.setAttribute("all1", mySqlSelectInAll.getAll());
        }else{
            request.setAttribute("all1", mySqlSelectInAll.getAllFilter(whereSearch, whatSearch));
        }
        page = JspPageName.SEARCH;
        return page;
        } catch (FactoryException e) {
            throw new CommandException(e);
        } catch (DAOException e) {
            throw new CommandException(e);
        }
    }
}