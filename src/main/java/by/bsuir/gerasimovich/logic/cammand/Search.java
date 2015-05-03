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
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Tatiana
 * @version 1.00 27.04.2015.
 */
public class Search implements ICommand {
    MySqlDaoFactory factory;
    MySqlSelectInAll mySqlSelectInAll;
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws PersistException {
        String page = null;
        String whereSearch = request.getParameter(RequestParameterName.WHERE_SEARCH);
        String whatSearch = request.getParameter(RequestParameterName.WHAT_SEARCH);
        factory = new MySqlDaoFactory();
        mySqlSelectInAll = (MySqlSelectInAll) factory.getDao( SelectAll.class);
        if(whereSearch.equals("notSearch")) {
            request.setAttribute("all1", mySqlSelectInAll.getAll());
        }else{
            request.setAttribute("all1", mySqlSelectInAll.getAllFilter(whereSearch, whatSearch));
        }
        page = JspPageName.SEARCH;
        return page;
    }
}