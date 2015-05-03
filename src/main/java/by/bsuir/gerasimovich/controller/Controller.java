package by.bsuir.gerasimovich.controller;

import by.bsuir.gerasimovich.dao.PersistException;
import by.bsuir.gerasimovich.logic.CommandHelper;
import by.bsuir.gerasimovich.logic.ICommand;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Tatiana
 * @version 1.00 20.04.2015.
 */

public class Controller extends HttpServlet{
    private static final long serialVersionUID = 1L;


    public static final Logger log = Logger.getRootLogger();

    private CommandHelper commandHelper = CommandHelper.getInstance();

    public Controller() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String commandName = request.getParameter(RequestParameterName.COMMAND_NAME);
        System.out.println(commandName);
        ICommand command = commandHelper.getCommand(commandName);
        String page = null;
        try {
            page = command.execute(request, response);
            RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
            rd.forward(request, response);
        } catch (ServletException ex) {
            log.error("servlet exception",ex);
            ex.printStackTrace();
        } catch (IOException ex) {
            log.error("IO exception", ex);
            ex.printStackTrace();
        }  catch (PersistException e) {
            log.error("Exception in DAO", e);
            e.printStackTrace();
        }
    }

}
