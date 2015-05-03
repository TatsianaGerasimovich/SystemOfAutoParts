package by.bsuir.gerasimovich.logic.cammand;

import by.bsuir.gerasimovich.logic.ICommand;
import by.bsuir.gerasimovich.controller.JspPageName;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class NoSuchCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return JspPageName.ERROR_PAGE;
    }
}
