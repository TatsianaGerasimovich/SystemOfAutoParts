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
import java.sql.SQLException;
import java.util.List;

/**
 * @author Tatiana
 * @version 1.00 27.04.2015.
 */
public class ListOfAllWithSort implements ICommand {
    MySqlDaoFactory factory;
    MySqlSelectInAll mySqlSelectInAll;
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws PersistException,SQLException {
        String page = null;
        String sortType = request.getParameter(RequestParameterName.SORT_TYPE);
        System.out.println(sortType);
        factory = new MySqlDaoFactory();
        mySqlSelectInAll = (MySqlSelectInAll) factory.getDao( SelectAll.class);
        List<SelectAll> list= mySqlSelectInAll.getAllSort(sortType);
        for (SelectAll obj: list){
            System.out.println(obj.toString());
        }
        request.setAttribute("all1", mySqlSelectInAll.getAllSort(sortType));
        page = JspPageName.LIST_OF_ALL_WITH_SORT;
        return page;
    }
}