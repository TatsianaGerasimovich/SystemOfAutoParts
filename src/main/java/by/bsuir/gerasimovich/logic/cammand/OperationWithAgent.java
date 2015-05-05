package by.bsuir.gerasimovich.logic.cammand;

import by.bsuir.gerasimovich.controller.JspPageName;
import by.bsuir.gerasimovich.controller.RequestParameterName;
import by.bsuir.gerasimovich.dao.PersistException;
import by.bsuir.gerasimovich.dao.mysql.MySqlCarBrandDao;
import by.bsuir.gerasimovich.dao.mysql.MySqlContractorDao;
import by.bsuir.gerasimovich.dao.mysql.MySqlDaoFactory;
import by.bsuir.gerasimovich.entity.CarBrand;
import by.bsuir.gerasimovich.entity.CarModel;
import by.bsuir.gerasimovich.entity.Contractor;
import by.bsuir.gerasimovich.logic.ICommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tatiana
 * @version 1.00 29.04.2015.
 */
public class OperationWithAgent implements ICommand {
    MySqlDaoFactory factory;
    MySqlContractorDao mySqlContractorDao;
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws PersistException {
        String page = null;
        String typeOfOperation = request.getParameter(RequestParameterName.TYPE_OF_OPERATION_WITH_AGENT);

        factory = MySqlDaoFactory.getInstance();
        mySqlContractorDao = (MySqlContractorDao) factory.getDao( Contractor.class);

        if(typeOfOperation.equals(RequestParameterName.CREATE_AGENT)){
            String nameOfAgent = request.getParameter(RequestParameterName.NAME_OF_AGENT);
            String addressOfAgent = request.getParameter(RequestParameterName.ADDRESS_OF_AGENT);
            String phoneOfAgent = request.getParameter(RequestParameterName.PHONE_OF_AGENT);
            String typeOfAgent = request.getParameter(RequestParameterName.TYPE_OF_AGENT);
            String ratingOfAgent = request.getParameter(RequestParameterName.RATING_OF_AGENT);
            Contractor contractor= new Contractor(mySqlContractorDao.getNewId(), nameOfAgent, typeOfAgent, Integer.valueOf(ratingOfAgent), addressOfAgent,Long.valueOf(phoneOfAgent) );
            mySqlContractorDao.persist(contractor);
        }
        if(typeOfOperation.equals(RequestParameterName.UPDATE_AGENT)){
            String idOfAgent = request.getParameter(RequestParameterName.ID_OF_AGENT);
            String nameOfAgent = request.getParameter(RequestParameterName.NAME_OF_AGENT);
            String addressOfAgent = request.getParameter(RequestParameterName.ADDRESS_OF_AGENT);
            String phoneOfAgent = request.getParameter(RequestParameterName.PHONE_OF_AGENT);
            String typeOfAgent = request.getParameter(RequestParameterName.TYPE_OF_AGENT);
            String ratingOfAgent = request.getParameter(RequestParameterName.RATING_OF_AGENT);
            Contractor contractor= new Contractor( Integer.valueOf(idOfAgent), nameOfAgent, typeOfAgent, Integer.valueOf(ratingOfAgent), addressOfAgent,Long.valueOf(phoneOfAgent) );
            mySqlContractorDao.update(contractor);
        }
        if(typeOfOperation.equals(RequestParameterName.DELETE_AGENT)){
            String idOfAgent = request.getParameter(RequestParameterName.ID_OF_AGENT);
            Contractor contractor= new Contractor( Integer.valueOf(idOfAgent), "", "", 0, "",0 );
            mySqlContractorDao.delete(contractor);
        }
        List<String> listType=new ArrayList<>(2);
        listType.add("provider");
        listType.add("recipient");

        List<Integer> listRating=new ArrayList<>();
        for(int i=1;i<=10;i++){
            listRating.add(i);
        }
        request.setAttribute("allTypeOfAgent", listType);
        request.setAttribute("allRating", listRating);
        request.setAttribute("all1", mySqlContractorDao.getAll());
        page = JspPageName.OPERATION_WITH_AGENTS;
        return page;
    }
}