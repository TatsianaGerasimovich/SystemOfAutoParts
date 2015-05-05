package by.bsuir.gerasimovich.logic.cammand;

import by.bsuir.gerasimovich.controller.JspPageName;
import by.bsuir.gerasimovich.controller.RequestParameterName;
import by.bsuir.gerasimovich.dao.PersistException;
import by.bsuir.gerasimovich.dao.mysql.MySqlCarBrandDao;
import by.bsuir.gerasimovich.dao.mysql.MySqlCarModelDao;
import by.bsuir.gerasimovich.dao.mysql.MySqlDaoFactory;
import by.bsuir.gerasimovich.entity.CarBrand;
import by.bsuir.gerasimovich.entity.CarModel;
import by.bsuir.gerasimovich.logic.ICommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.*;

/**
 * @author Tatiana
 * @version 1.00 29.04.2015.
 */
public class OperationWithModel implements ICommand {
    MySqlDaoFactory factory;
    MySqlCarModelDao mySqlCarModelDao;
    MySqlCarBrandDao mySqlCarBrandDao;
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws PersistException {
        String page = null;
        String typeOfOperation = request.getParameter(RequestParameterName.TYPE_OF_OPERATION_WITH_MODEL);

        factory = MySqlDaoFactory.getInstance();
        mySqlCarModelDao = (MySqlCarModelDao) factory.getDao( CarModel.class);
        mySqlCarBrandDao = (MySqlCarBrandDao) factory.getDao( CarBrand.class);
        if(typeOfOperation.equals(RequestParameterName.CREATE_MODEL)){
            String idCarBrandWithName = request.getParameter(RequestParameterName.ID_OF_CAR_BRAND);
            String idCarBrand = idCarBrandWithName.substring(0, idCarBrandWithName.indexOf('('));
            String nameModel = request.getParameter(RequestParameterName.NAME_OF_CAR_MODEL);
            String yearOfModel = request.getParameter(RequestParameterName.YEAR_OF_CAR_MODEL);
            CarModel carModel=new CarModel(mySqlCarModelDao.getNewId(),Integer.valueOf(idCarBrand),nameModel,Integer.valueOf(yearOfModel));
            mySqlCarModelDao.persist(carModel);
        }
        if(typeOfOperation.equals(RequestParameterName.UPDATE_MODEL)){
            String idCarModelWithBrand = request.getParameter(RequestParameterName.ID_OF_CAR_MODEL);
            String idCarModel = idCarModelWithBrand.substring(0, idCarModelWithBrand.indexOf('-'));
            String idCarBrand = idCarModelWithBrand.substring(idCarModelWithBrand.indexOf('-')+1, idCarModelWithBrand.length());
            String nameModel = request.getParameter(RequestParameterName.NAME_OF_CAR_MODEL);
            String yearOfModel = request.getParameter(RequestParameterName.YEAR_OF_CAR_MODEL);
            CarModel carModel=new CarModel(Integer.valueOf(idCarModel),Integer.valueOf(idCarBrand),nameModel,Integer.valueOf(yearOfModel));
            mySqlCarModelDao.update(carModel);
        }
        if(typeOfOperation.equals(RequestParameterName.DELETE_MODEL)){
            String idCarModelWithBrand = request.getParameter(RequestParameterName.ID_OF_CAR_MODEL);
            String idCarModel = idCarModelWithBrand.substring(0, idCarModelWithBrand.indexOf('-'));
            String idCarBrand = idCarModelWithBrand.substring(idCarModelWithBrand.indexOf('-')+1, idCarModelWithBrand.length());
            CarModel carModel=new CarModel(Integer.valueOf(idCarModel),Integer.valueOf(idCarBrand),"",0);
            mySqlCarModelDao.delete(carModel);
        }
        request.setAttribute("all1", mySqlCarModelDao.getAll());
        request.setAttribute("allBrand", mySqlCarBrandDao.getAll());
        List<CarModel> list=mySqlCarModelDao.getAll();
        List<CarBrand> listBrand=new ArrayList<>(list.size());
        for(CarModel obj : list){
            listBrand.add(mySqlCarBrandDao.getByPK(obj.getCarBrandId(),"CarBrandId"));
        }
        List<Integer> listYears=new ArrayList<>();

        for(int i=1930;i<=getCurrentYear();i++){
            listYears.add(i);
        }
        request.setAttribute("allModel", mySqlCarModelDao.getAll());
        request.setAttribute("allBrandByModel", listBrand);
        request.setAttribute("allYears", listYears);
        page = JspPageName.OPERATION_WITH_MODELS;
        return page;
    }
    public static int getCurrentYear()
    {
        java.util.Calendar calendar = java.util.Calendar.getInstance(java.util.TimeZone.getDefault(), java.util.Locale.getDefault());
        calendar.setTime(new java.util.Date());
        return calendar.get(java.util.Calendar.YEAR);
    }
}