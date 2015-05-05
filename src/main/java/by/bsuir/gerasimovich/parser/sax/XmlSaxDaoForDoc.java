package by.bsuir.gerasimovich.parser.sax;

import by.bsuir.gerasimovich.entity.Document;
import by.bsuir.gerasimovich.entity.Documents_has_AutoParts;
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
public class XmlSaxDaoForDoc {


    private static XmlSaxDaoForDoc instance;
    private SaxParsHandler saxParsHandler;
    private XMLReader xmlReader;

    private XmlSaxDaoForDoc() {
        //   this.fileName = "autoparts.xml";
        saxParsHandler = new SaxParsHandler();
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(saxParsHandler);
        } catch (SAXException e) {
            throw new ParseXMLException("unable to create SAX parser");
        }
    }

    public static XmlSaxDaoForDoc getInstance() {
        if (instance == null) {
            synchronized (XmlSaxDaoForDoc.class) {
                if (instance == null) {
                    instance = new XmlSaxDaoForDoc();
                }
            }
        }
        return instance;
    }

    public List<Documents_has_AutoParts> getListDoc(String fileName) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        File file = new File("D:\\Work\\idea\\SystemOfAutoparts\\src\\main\\resources\\" + fileName);

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

    }

    public Document getDoc(String fileName) {
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
            return saxParsHandler.getDoc();
        } else return null;
    }

}
