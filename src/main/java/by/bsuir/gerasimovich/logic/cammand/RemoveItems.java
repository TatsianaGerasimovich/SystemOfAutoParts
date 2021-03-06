package by.bsuir.gerasimovich.logic.cammand;

import by.bsuir.gerasimovich.controller.JspPageName;
import by.bsuir.gerasimovich.controller.RequestParameterName;
import by.bsuir.gerasimovich.dao.PersistException;
import by.bsuir.gerasimovich.dao.mysql.*;
import by.bsuir.gerasimovich.entity.*;
import by.bsuir.gerasimovich.logic.ICommand;
import by.bsuir.gerasimovich.parser.sax.XmlSaxDaoForDoc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Tatiana
 * @version 1.00 02.05.2015.
 */
public class RemoveItems implements ICommand {
    MySqlDaoFactory factory;
    MySqlContractorDao mySqlContractorDao;
    MySqlAutoPartDao mySqlAutoPartDao;
    MySqlCarBrandDao mySqlCarBrandDao;
    MySqlDocuments_has_AutoPartsDao mySqlDocuments_has_autoPartsDao;
    MySqlDocumentDao mySqlDocumentDao;
    static int count;
    static int idDocument;
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws PersistException {
        String page = null;
        String typeOfOperation = request.getParameter(RequestParameterName.TYPE_OF_REMOVE_ITEMS);

        factory = MySqlDaoFactory.getInstance();
        mySqlContractorDao = (MySqlContractorDao) factory.getDao( Contractor.class);
        mySqlAutoPartDao=(MySqlAutoPartDao) factory.getDao(AutoPart.class);
        mySqlCarBrandDao = (MySqlCarBrandDao) factory.getDao( CarBrand.class);
        mySqlDocuments_has_autoPartsDao=(MySqlDocuments_has_AutoPartsDao) factory.getDao(Documents_has_AutoParts.class);
        mySqlDocumentDao = (MySqlDocumentDao) factory.getDao( Document.class);

        if(typeOfOperation.equals(RequestParameterName.REMOVE_AUTOPART)){
            String idOfAutopart = request.getParameter(RequestParameterName.ID_OF_AUTO_PART);
            AutoPart autoPart =new AutoPart(Integer.valueOf(idOfAutopart),"");
            mySqlAutoPartDao.delete(autoPart);
            request.setAttribute("message1", "Данный вид автозапчасти удалён");
        }

        if(typeOfOperation.equals(RequestParameterName.REMOVE_BY_FILE)){
            String nameOfFile = request.getParameter(RequestParameterName.NAME_OF_FILE);
            nameOfFile+=".xml";
            System.out.println(nameOfFile);
            XmlSaxDaoForDoc dao=  XmlSaxDaoForDoc.getInstance();
            Document document=dao.getDoc(nameOfFile);
            if(document!=null) {

                document.setDocumentType("shipment of invoice");
                List<Documents_has_AutoParts> list = dao.getListDoc(nameOfFile);
                int documentId = mySqlDocumentDao.getNewId();
                document.setId(documentId);
                mySqlDocumentDao.persist(document);
                for (Documents_has_AutoParts obj : list) {
                    obj.setDocumentId(documentId);
                    mySqlDocuments_has_autoPartsDao.persist(obj);
                }
                request.setAttribute("message2", "Накладная введена в базу");
            }
            else request.setAttribute("message2", "Данный файл не существует");

        }
        if(typeOfOperation.equals(RequestParameterName.REMOVE_INVOICE_BY_KEYBOARD)){
            String date = request.getParameter(RequestParameterName.DATE_OF_INVOICE);
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("dd.MM.yyyy");
            Date docDate=null;
            try {
                docDate= format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String idOfAgent = request.getParameter(RequestParameterName.ID_OF_AGENT);
            String numberOfItems = request.getParameter(RequestParameterName.NUMBER_OF_AUTO_PARTS_ITEMS);
            count=Integer.parseInt(numberOfItems);
            idDocument=mySqlDocumentDao.getNewId();
            Document document = new Document(idDocument,Integer.parseInt(idOfAgent),"shipment of invoice",new java.sql.Date(docDate.getTime()));
            System.out.println(document.toString());
            mySqlDocumentDao.persist(document);
            request.setAttribute("message3", "Введите данные по оставшимся "+count+" автозапчастям");
        }
        if(typeOfOperation.equals(RequestParameterName.REMOVE_DETAILS_BY_KEYBOARD)){
            count--;
            String idOfAutoParts = request.getParameter(RequestParameterName.ID_OF_AUTO_PART);
            String price = request.getParameter(RequestParameterName.PRICE_OF_AUTO_PARTS);
            String number = request.getParameter(RequestParameterName.NUMBER_OF_AUTO_PARTS);
            int num=Integer.parseInt(number);
            num=num-2*num;
            String currency = request.getParameter(RequestParameterName.TYPE_OF_CURRENCY);
            Documents_has_AutoParts details = new Documents_has_AutoParts(Integer.parseInt(idOfAutoParts),idDocument,Integer.parseInt(price),num,currency);
            System.out.println(details.toString());
            mySqlDocuments_has_autoPartsDao.persist(details);
            request.setAttribute("message3", "Введите данные по \n оставшимся "+count+" автозапчастям");
        }

        List<String> listCurrency=new ArrayList<>(2);
        listCurrency.add("RUB");
        listCurrency.add("USD");
        listCurrency.add("EUR");
        listCurrency.add("BYR");

        request.setAttribute("allCurrency", listCurrency);
        request.setAttribute("allAutoParts", mySqlAutoPartDao.getAll());
        request.setAttribute("allAgent", mySqlContractorDao.getAll());
        page = JspPageName.REMOVE_ITEMS;
        return page;
    }
}