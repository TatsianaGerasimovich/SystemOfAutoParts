package by.bsuir.gerasimovich.parserBrands.sax;

import by.bsuir.gerasimovich.entity.AutoPart;
import by.bsuir.gerasimovich.entity.AutoParts_has_CarModels;
import by.bsuir.gerasimovich.parserBrands.BrandsEnum;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


import java.util.ArrayList;
import java.util.List;
/**
 * @author Tatiana
 * @version 1.00 22.04.2015.
 */
public class SaxParsHandler extends DefaultHandler {

    private List<AutoParts_has_CarModels> list;
    private AutoParts_has_CarModels currentDoc;
    private BrandsEnum currentEnum;

    public SaxParsHandler() {
        super();
        list =new ArrayList<AutoParts_has_CarModels>();
    }

    public List<AutoParts_has_CarModels> getListDoc() {
        return list;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentEnum = BrandsEnum.getEnum(localName);
        switch (currentEnum){
            case AUTOPARTS_MODEL:
                currentDoc =new AutoParts_has_CarModels();
                break;
            case AUTOPARTS_MODELS:
                list = new ArrayList<AutoParts_has_CarModels>();
                break;
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        BrandsEnum currentElement = BrandsEnum.getEnum(localName);
        switch (currentElement){
            case AUTOPARTS_MODEL:
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
                case AUTOPART_ID:
                    currentDoc.setAutoPartId(Integer.parseInt(value));
                    break;
                case MODEL_ID:
                    currentDoc.setCarModelId(Integer.parseInt(value));
                    break;
                case BRAND_ID:
                    currentDoc.setCarBrandId(Integer.parseInt(value));
                    break;
            }
        }
        currentEnum=null;
    }
}
