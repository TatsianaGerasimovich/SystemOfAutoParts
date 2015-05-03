package by.bsuir.gerasimovich.logic.cammand;

import by.bsuir.gerasimovich.controller.JspPageName;
import by.bsuir.gerasimovich.controller.RequestParameterName;
import by.bsuir.gerasimovich.dao.PersistException;
import by.bsuir.gerasimovich.dao.mysql.MySqlDaoFactory;
import by.bsuir.gerasimovich.dao.mysql.MySqlSelectInAll;
import by.bsuir.gerasimovich.entity.SelectAll;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;

/**
 * @author Tatiana
 * @version 1.00 29.04.2015.
 */
public class Test {
    public static void main(String[] args) {
        MySqlDaoFactory factory;
        MySqlSelectInAll mySqlSelectInAll;
        String page = null;
        factory = new MySqlDaoFactory();
        try {
            mySqlSelectInAll = (MySqlSelectInAll) factory.getDao( SelectAll.class);
            List<SelectAll> list= mySqlSelectInAll.getAllScarce();
            for (SelectAll obj: list){
                System.out.println(obj.toString());
            }

        } catch (PersistException e) {
            e.printStackTrace();

        }
    }
}
