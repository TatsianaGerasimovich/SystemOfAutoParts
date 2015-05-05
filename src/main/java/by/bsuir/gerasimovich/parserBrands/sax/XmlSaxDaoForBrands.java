package by.bsuir.gerasimovich.parserBrands.sax;

import by.bsuir.gerasimovich.entity.AutoParts_has_CarModels;
import by.bsuir.gerasimovich.parser.ParseXMLException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Tatiana
 * @version 1.00 22.04.2015.
 */
public class XmlSaxDaoForBrands {


    private static XmlSaxDaoForBrands instance;
    private SaxParsHandler saxParsHandler;
    private XMLReader xmlReader;

    private XmlSaxDaoForBrands() {
        saxParsHandler = new SaxParsHandler();
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(saxParsHandler);
        } catch (SAXException e) {
            throw new ParseXMLException("unable to create SAX parser");
        }
    }

    public static XmlSaxDaoForBrands getInstance() {
        if (instance == null) {
            synchronized (XmlSaxDaoForBrands.class) {
                if (instance == null) {
                    instance = new XmlSaxDaoForBrands();
                }
            }
        }
        return instance;
    }

    public List<AutoParts_has_CarModels> getListDoc(String fileName) {
        File file = new File("D:\\Work\\idea\\SystemOfAutoparts\\src\\main\\resources\\" + fileName);
        if (file.exists()) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        InputStream stream = loader.getResourceAsStream(fileName);
        InputSource source = new InputSource(stream);
        try {
            xmlReader.parse(source);
        } catch (SAXException e) {
            throw new ParseXMLException("error in parsing ", e);

        } catch (IOException e) {
            throw new ParseXMLException("error in IOstream while parsing");
        }
        return saxParsHandler.getListDoc();
        } else return null;

    }
}
