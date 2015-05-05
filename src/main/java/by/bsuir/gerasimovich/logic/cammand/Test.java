package by.bsuir.gerasimovich.logic.cammand;

import by.bsuir.gerasimovich.dao.PersistException;
import by.bsuir.gerasimovich.dao.mysql.MySqlDaoFactory;
import by.bsuir.gerasimovich.dao.mysql.MySqlDocumentDao;
import by.bsuir.gerasimovich.dao.mysql.MySqlDocuments_has_AutoPartsDao;
import by.bsuir.gerasimovich.dao.mysql.MySqlSelectInAll;
import by.bsuir.gerasimovich.entity.Document;
import by.bsuir.gerasimovich.entity.Documents_has_AutoParts;
import by.bsuir.gerasimovich.entity.SelectAll;
import by.bsuir.gerasimovich.parser.sax.XmlSaxDaoForDoc;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author Tatiana
 * @version 1.00 29.04.2015.
 */
public class Test {
    public static void main(String[] args) throws PersistException {
        MySqlDaoFactory factory;
        MySqlSelectInAll mySqlSelectInAll;
        factory = MySqlDaoFactory.getInstance();
        try {
            mySqlSelectInAll = (MySqlSelectInAll) factory.getDao( SelectAll.class);
            List<SelectAll> list= mySqlSelectInAll.getAllScarce();
            File file = new File("D:\\Work\\idea\\SystemOfAutoparts\\ReportAboutScarce.html");
            if(!file.exists()){
                file.createNewFile();
            }
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                out.println( "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");
                out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
                out.println("<head>");
                out.println("<title>Report</title>");
                out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=cp1251\" />");
                out.println("</head>");
                out.println("<body>");
                out.println("<H2 align=\"center\">"+"Отчёт"+"</H2>");
                out.println("<H3 align=\"center\">"+"о дефицитных запчастях"+"</H3>");
                out.println("<H5 align=\"center\">"+"Дата:"+new java.util.Date ().toString ()+"</H3>");
                if(list.isEmpty()){
                    out.println("<H5 align=\"center\">"+"Дефицитных автозапчастей нет"+"</H3>");
                }
                else {
                    out.println("<table align=\"center\" border=1>");
                    out.println("<thead>");
                    out.println("<tr>\n" +
                            "<th>Identification number</th>\n" +
                            "<th>Name autopart</th>\n" +
                            "<th>Name car brand</th>\n" +
                            "<th>Name car model</th>\n" +
                            "<th>Year of release</th>\n" +
                            "<th>Name of agent</th>\n" +
                            "<th>Price</th>\n" + "<th>Number</th>\n" + "</tr>");
                    out.println("</thead>");
                    out.println("<tbody>");
                    for (SelectAll obj : list) {
                        out.println("<tr>");
                        out.println("<td>" + obj.getAutoPartId() + "</td>");
                        out.println("<td>" + obj.getName() + "</td>");
                        out.println("<td>" + obj.getNameBrand() + "</td>");
                        out.println("<td>" + obj.getNameModel() + "</td>");
                        out.println("<td>" + obj.getYearOfRelease() + "</td>");
                        out.println("<td>" + obj.getNameOfAgent() + "</td>");
                        out.println("<td>" + obj.getPrice() + "</td>");
                        out.println("<td>" + obj.getNumber() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</tbody>");
                    out.println("</table>");
                    out.println("</body>");
                    out.println("</html>");
                }
            } finally {

                out.close();
            }
        } catch (PersistException e) {
            e.printStackTrace();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
