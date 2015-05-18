package by.bsuir.gerasimovich.logic.command;

import by.bsuir.gerasimovich.controller.JspPageName;
import by.bsuir.gerasimovich.controller.RequestParameterName;
import by.bsuir.gerasimovich.dao.DAOException;
import by.bsuir.gerasimovich.dao.FactoryException;
import by.bsuir.gerasimovich.dao.mysql.*;
import by.bsuir.gerasimovich.entity.*;
import by.bsuir.gerasimovich.logic.CommandException;
import by.bsuir.gerasimovich.logic.ICommand;
import by.bsuir.gerasimovich.logic.ParametrName;
import by.bsuir.gerasimovich.parser.sax.XmlSaxDaoForDoc;
import by.bsuir.gerasimovich.parserBrands.sax.XmlSaxDaoForBrands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Tatiana
 * @version 1.00 02.05.2015.
 */
public class EnterNewItems implements ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String page = null;
        String typeOfOperation = request.getParameter(RequestParameterName.TYPE_OF_ENTER_NEW_AUTO_PARTS);
        MySqlDaoFactory factory;
        MySqlContractorDao mySqlContractorDao;
        MySqlDocuments_has_AutoPartsDao mySqlDocuments_has_autoPartsDao;
        MySqlDocumentDao mySqlDocumentDao;
        MySqlAutoPartDao mySqlAutoPartDao;
        MySqlCarBrandDao mySqlCarBrandDao;
        MySqlAutoParts_has_CarModelsDao mySqlAutoParts_has_carModelsDao;
        factory =  MySqlDaoFactory.getInstance();
        HttpSession session = request.getSession();
        try {
            mySqlContractorDao = (MySqlContractorDao) factory.getDao( Contractor.class);
            mySqlAutoPartDao=(MySqlAutoPartDao) factory.getDao(AutoPart.class);
            mySqlCarBrandDao = (MySqlCarBrandDao) factory.getDao( CarBrand.class);
            mySqlDocuments_has_autoPartsDao=(MySqlDocuments_has_AutoPartsDao) factory.getDao(Documents_has_AutoParts.class);
            mySqlDocumentDao = (MySqlDocumentDao) factory.getDao( Document.class);
            mySqlAutoParts_has_carModelsDao= (MySqlAutoParts_has_CarModelsDao) factory.getDao( AutoParts_has_CarModels.class);
        if(typeOfOperation.equals(RequestParameterName.NOTHING)){
            session.setAttribute(ParametrName.COUNT, -1);
            }
        if(typeOfOperation.equals(RequestParameterName.ENTER_BY_FILE)){
            String nameOfFile = request.getParameter(RequestParameterName.NAME_OF_FILE);
            nameOfFile+=".xml";
            XmlSaxDaoForDoc dao=  XmlSaxDaoForDoc.getInstance();
            Document document=dao.getDoc(nameOfFile);
            if(document!=null) {

                document.setDocumentType("receipt of invoice");
                List<Documents_has_AutoParts> list = dao.getListDoc(nameOfFile);
                int documentId = 0;

                    documentId = mySqlDocumentDao.getNewId();

                document.setId(documentId);
                mySqlDocumentDao.persist(document);
                for (Documents_has_AutoParts obj : list) {
                    obj.setDocumentId(documentId);
                    mySqlDocuments_has_autoPartsDao.persist(obj);
                }
                request.setAttribute(ParametrName.MESSAGE1, "Накладная введена в базу");
            }
            else request.setAttribute(ParametrName.MESSAGE1, "Данный файл не существует");
        }
        if(typeOfOperation.equals(RequestParameterName.NEW_AUTOPART)){
            String nameOfAutopart = request.getParameter(RequestParameterName.NAME_OF_AUTOPART);
            AutoPart autoPart =new AutoPart(mySqlAutoPartDao.getNewId(),nameOfAutopart);
            mySqlAutoPartDao.persist(autoPart);
            request.setAttribute(ParametrName.MESSAGE3, "Новый вид автозапчасти добавлен");
        }
        if(typeOfOperation.equals(RequestParameterName.ENTER_INVOICE_BY_KEYBOARD)){
            String date = request.getParameter(RequestParameterName.DATE_OF_INVOICE);
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("yyyy-MM-dd");
            Date docDate=null;
            try {
                docDate= format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String idOfAgent = request.getParameter(RequestParameterName.ID_OF_AGENT);
            String numberOfItems = request.getParameter(RequestParameterName.NUMBER_OF_AUTO_PARTS_ITEMS);
            session.setAttribute(ParametrName.COUNT, Integer.parseInt(numberOfItems));
            int idDocument=mySqlDocumentDao.getNewId();
            session.setAttribute("idDocument", idDocument);
            Document document = new Document(idDocument,Integer.parseInt(idOfAgent),"receipt of invoice",new java.sql.Date(docDate.getTime()));
            mySqlDocumentDao.persist(document);

            request.setAttribute(ParametrName.MESSAGE2, "Введите данные по оставшимся "+(Integer) session.getAttribute("count")+" автозапчастям");
        }
        if(typeOfOperation.equals(RequestParameterName.ENTER_DETAILS_BY_KEYBOARD)){
            int count=(Integer) session.getAttribute("count");
            if(count==-1){
                request.setAttribute("error", "Извинете, необходимо ввести сначала данные об накладной");
                page = JspPageName.ERROR_PAGE;
                return page;
            }
            else if(count==0){
                request.setAttribute(ParametrName.MESSAGE2, "Все данные уже введены");
            }
            else {
                count--;
                session.setAttribute(ParametrName.COUNT, count);
                String idOfAutoParts = request.getParameter(RequestParameterName.ID_OF_AUTO_PART);
                String price = request.getParameter(RequestParameterName.PRICE_OF_AUTO_PARTS);
                String number = request.getParameter(RequestParameterName.NUMBER_OF_AUTO_PARTS);
                String currency = request.getParameter(RequestParameterName.TYPE_OF_CURRENCY);
                Documents_has_AutoParts details = new Documents_has_AutoParts(Integer.parseInt(idOfAutoParts), (Integer) session.getAttribute("idDocument"), Integer.parseInt(price), Integer.parseInt(number), currency);
                mySqlDocuments_has_autoPartsDao.persist(details);
                if(count==0){
                    request.setAttribute(ParametrName.MESSAGE2, "Спасибо за вод необходимых данных");
                }
                else request.setAttribute(ParametrName.MESSAGE2, "Введите данные по оставшимся " + (Integer) session.getAttribute("count") + " автозапчастям");
            }
            }
        if(typeOfOperation.equals(RequestParameterName.ENTER_BRANDS_BY_FILE)){
            String nameOfFile = request.getParameter(RequestParameterName.NAME_OF_FILE);
            nameOfFile+=".xml";
            XmlSaxDaoForBrands dao=  XmlSaxDaoForBrands.getInstance();
            List<AutoParts_has_CarModels> list = dao.getListDoc(nameOfFile);
            if(list!=null) {
                for (AutoParts_has_CarModels obj : list) {
                    mySqlAutoParts_has_carModelsDao.persist(obj);
                }
                request.setAttribute(ParametrName.MESSAGE4, "Данные введена в базу");
            }
            else request.setAttribute(ParametrName.MESSAGE4, "Данный файл не существует");
        }

        List<String> listCurrency=new ArrayList<>(2);
        listCurrency.add("RUB");
        listCurrency.add("USD");
        listCurrency.add("EUR");
        listCurrency.add("BYR");

        request.setAttribute(ParametrName.ALLCURRENCY, listCurrency);
        request.setAttribute(ParametrName.ALLAUTOPARTS, mySqlAutoPartDao.getAll());
        request.setAttribute(ParametrName.ALLBRAND, mySqlCarBrandDao.getAll());
        request.setAttribute(ParametrName.ALLAGENT, mySqlContractorDao.getAll());
        page = JspPageName.ENTER_NEW_ITEMS;
        return page;
        } catch (FactoryException e) {
            throw new CommandException(e);
    } catch (DAOException e) {
            throw new CommandException(e);
        }
    }
}