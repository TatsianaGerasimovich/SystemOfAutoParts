package by.bsuir.gerasimovich.logic;

import by.bsuir.gerasimovich.dao.PersistException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public interface ICommand {
    public String execute(HttpServletRequest request, HttpServletResponse response)throws PersistException,SQLException;
}
