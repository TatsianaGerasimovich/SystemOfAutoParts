package by.bsuir.gerasimovich.logic.command;

import by.bsuir.gerasimovich.controller.JspPageName;
import by.bsuir.gerasimovich.controller.RequestParameterName;
import by.bsuir.gerasimovich.dao.DAOException;
import by.bsuir.gerasimovich.dao.FactoryException;
import by.bsuir.gerasimovich.dao.mysql.MySqlDaoFactory;
import by.bsuir.gerasimovich.dao.mysql.MySqlSelectInAll;
import by.bsuir.gerasimovich.entity.SelectAll;
import by.bsuir.gerasimovich.logic.CommandException;
import by.bsuir.gerasimovich.logic.ICommand;
import by.bsuir.gerasimovich.logic.ParametrName;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author Tatiana
 * @version 1.00 30.04.2015.
 */
public class GenerationReport implements ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        MySqlDaoFactory factory;
        MySqlSelectInAll mySqlSelectInAll;
        String page = null;
        String typeOfReport = request.getParameter(RequestParameterName.TYPE_OF_REPORT);
        factory = MySqlDaoFactory.getInstance();
        try {
            mySqlSelectInAll = (MySqlSelectInAll) factory.getDao( SelectAll.class);

        if(typeOfReport.equals(RequestParameterName.REPORT_OF_ALL_AUTOPARTS)){
            generateReportOfAll();
            request.setAttribute(ParametrName.REPORTALL1,"Отчёт создан");

        }
        if(typeOfReport.equals(RequestParameterName.REPORT_OF_ALL_SCARCE)){
            generateReportOfScarce();
            request.setAttribute(ParametrName.REPORTALL2,"Отчёт создан");
        }
        if(typeOfReport.equals(RequestParameterName.REPORT_OF_RESIDUES_IN_STOCK)){
            generateReportOfResiduesInStock(request, response);
            request.setAttribute(ParametrName.REPORTALL3,"Отчёт создан");
        }

        request.setAttribute(ParametrName.ALLAUTOPARTS,mySqlSelectInAll.getAll());
        page = JspPageName.GENERATION_REPORT;
        return page;
        } catch (FactoryException e) {
            throw new CommandException(e);
        } catch (DAOException e) {
            throw new CommandException(e);
        }
    }
    private void generateReportOfAll() throws FactoryException, DAOException, CommandException {
        MySqlDaoFactory factory;
        MySqlSelectInAll mySqlSelectInAll;
        factory = MySqlDaoFactory.getInstance();
        try {
            mySqlSelectInAll = (MySqlSelectInAll) factory.getDao( SelectAll.class);
            List<SelectAll> list= mySqlSelectInAll.getAll();
            File file = new File("D:\\Work\\idea\\SystemOfAutoparts\\ReportAboutAll.html");
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
                out.println("<H3 align=\"center\">"+"о количестве всех видов запчастей"+"</H3>");
                out.println("<H5 align=\"center\">"+"Дата:"+new java.util.Date ().toString ()+"</H3>");
                if(list.isEmpty()){
                    out.println("<H5 align=\"center\">"+"На складе пока нет автозапчастей"+"</H3>");
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
        } catch(IOException e) {
            throw new CommandException(e);
        }
    }
    private void generateReportOfScarce() throws FactoryException, DAOException, CommandException{
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
                            "<th>Number</th>\n" + "</tr>");
                    out.println("</thead>");
                    out.println("<tbody>");
                    for (SelectAll obj : list) {
                        out.println("<tr>");
                        out.println("<td>" + obj.getAutoPartId() + "</td>");
                        out.println("<td>" + obj.getName() + "</td>");
                        out.println("<td>" + obj.getNameBrand() + "</td>");
                        out.println("<td>" + obj.getNameModel() + "</td>");
                        out.println("<td>" + obj.getYearOfRelease() + "</td>");
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
        } catch(IOException e) {
            throw new CommandException(e);
        }
    }
    private void generateReportOfResiduesInStock(HttpServletRequest request, HttpServletResponse response)throws FactoryException, DAOException, CommandException {
        MySqlDaoFactory factory;
        MySqlSelectInAll mySqlSelectInAll;
        int allNumber=0;
        factory = MySqlDaoFactory.getInstance();
        String autopartId = request.getParameter(RequestParameterName.ID_OF_AUTO_PART);
        try {
            mySqlSelectInAll = (MySqlSelectInAll) factory.getDao( SelectAll.class);
            List<SelectAll> list= mySqlSelectInAll.getAllFilter("AutoParts.AutoPartId", autopartId);
            File file = new File("D:\\Work\\idea\\SystemOfAutoparts\\ReportAboutResiduesInStock.html");
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
                out.println("<H3 align=\"center\">"+"об остатках на складе данной запчасти"+"</H3>");
                out.println("<H5 align=\"center\">"+"Дата:"+new java.util.Date ().toString ()+"</H3>");
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
                        allNumber+=obj.getNumber();
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
                    out.println("<H4 align=\"center\">"+"Общее количество:"+allNumber+"</H4>");
                    out.println("</body>");
                    out.println("</html>");
              } finally {

                out.close();
            }
        } catch(IOException e) {
            throw new CommandException(e);
        }
    }
}
