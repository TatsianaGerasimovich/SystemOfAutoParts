package by.bsuir.gerasimovich.parser.sax;

import by.bsuir.gerasimovich.entity.Document;
import by.bsuir.gerasimovich.entity.Documents_has_AutoParts;
import by.bsuir.gerasimovich.parser.AutoPartsEnum;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @author Tatiana
 * @version 1.00 22.04.2015.
 */
public class SaxParsHandler extends DefaultHandler {

    private Document document;
    private List<Documents_has_AutoParts> list;
    private Documents_has_AutoParts currentDoc;
    private AutoPartsEnum currentEnum;

    public SaxParsHandler() {
        super();
        list =new ArrayList<Documents_has_AutoParts>();
    }

    public List<Documents_has_AutoParts> getListDoc() {
        return list;
    }
    public Document getDoc() {
        return document;
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentEnum = AutoPartsEnum.getEnum(localName);
        switch (currentEnum){
            case INVOICE:
                document =new Document();
                break;
            case AUTOPART:
                currentDoc =new Documents_has_AutoParts();
                break;
            case AUTOPARTS:
                list = new ArrayList<Documents_has_AutoParts>();
                break;
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        AutoPartsEnum currentElement = AutoPartsEnum.getEnum(localName);
        switch (currentElement){
            case AUTOPART:
                list.add(currentDoc);
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length).trim();
        if(value.contains("\n")){return;}
        if (currentEnum != null) {
            switch (currentEnum) {
                case DATE:
                    String date=value;
                    SimpleDateFormat format = new SimpleDateFormat();
                    format.applyPattern("dd.MM.yyyy");
                    Date docDate=null;
                    try {
                        docDate= format.parse(date);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    document.setDate(new java.sql.Date(docDate.getTime()));
                    break;
                case AGENTID:
                    document.setAgentId(Integer.parseInt(value));
                    break;
                case AUTOPARTID:
                    currentDoc.setAutoParts_autoPartId(Integer.parseInt(value));
                    break;
                case PRICE:
                    currentDoc.setPrice(Integer.parseInt(value));
                    break;
                case NUMBER:
                    currentDoc.setNumber(Integer.parseInt(value));
                    break;
                case CURRENCY:
                    currentDoc.setCurrency(value);
                    break;
            }
        }
        currentEnum=null;
    }
}
