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
import by.bsuir.gerasimovich.logic.ParametrName;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Tatiana
 * @version 1.00 27.04.2015.
 */
public class ListOfAllWithSort implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        MySqlDaoFactory factory;
        MySqlSelectInAll mySqlSelectInAll;
        String page = null;
        String sortType = request.getParameter(RequestParameterName.SORT_TYPE);
        System.out.println(sortType);
        factory = MySqlDaoFactory.getInstance();
        try {
            mySqlSelectInAll = (MySqlSelectInAll) factory.getDao( SelectAll.class);
        List<SelectAll> list= mySqlSelectInAll.getAllSort(sortType);
        for (SelectAll obj: list){
            System.out.println(obj.toString());
        }
        request.setAttribute(ParametrName.ALL1, mySqlSelectInAll.getAllSort(sortType));
        page = JspPageName.LIST_OF_ALL_WITH_SORT;
        return page;
        } catch (FactoryException e) {
            throw new CommandException(e);
        } catch (DAOException e) {
            throw new CommandException(e);
        }
    }
}