package com.ccorchyts.jwd.task02.util.xmlparsing.saxparsing.impl;

import com.ccorchyts.jwd.task02.entity.Appliance;
import com.ccorchyts.jwd.task02.util.xmlparsing.saxparsing.ApplianceCatalogParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ApplianceCatalogXMLParserImpl implements ApplianceCatalogParser {

    @Override
    public List<Appliance> readCatalogFromFile(String fileName) {
        List<Appliance> catalog;
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = null;
        try {
            parser = factory.newSAXParser();
            catalog = new ArrayList<>();
            ApplianceCatalogXMLHandler handler = new ApplianceCatalogXMLHandler(catalog);
            File xmlDbFileName = new File(Objects.requireNonNull(ApplianceCatalogXMLParserImpl.class.getClassLoader().getResource(fileName)).getFile());
            parser.parse(xmlDbFileName, handler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
        return catalog;
    }
}
