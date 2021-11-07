package com.ccorchyts.jwd.task02.util.xmlparsing.domwriting;

import com.ccorchyts.jwd.task02.entity.Appliance;
import com.ccorchyts.jwd.task02.entity.impl.Oven;
import com.ccorchyts.jwd.task02.util.xmlparsing.saxparsing.ApplianceCatalogParser;
import com.ccorchyts.jwd.task02.util.xmlparsing.saxparsing.impl.ApplianceCatalogXMLParserImpl;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DOMWriter {
    private static final String DB_SOURCE_FILE_NAME = "bd_1.xml";
    private static final String DB_DEST_FILE_NAME = "bd_2.xml";

    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException, SAXException {

        ApplianceCatalogParser applianceCatalogParser = new ApplianceCatalogXMLParserImpl();
        List<Appliance> appliances = applianceCatalogParser.readCatalogFromFile(DB_SOURCE_FILE_NAME);


        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
//        File xmlDbFileName = new File(Objects.requireNonNull(SAXMain.class.getClassLoader().getResource(DB_DEST_FILE_NAME)).getFile());
        Document document = builder.newDocument();
//        document.createAttributeNS("http://www.task01.tc.by", "tns");

        Element appliancesElement = document.createElementNS("http://www.task01.tc.by", "tns:appliances");

        appliances.forEach(appliance -> {
            if (appliance instanceof Oven) {
                Oven oven = (Oven) appliance;
                Element ovenElement = document.createElement("oven");
                Element element = document.createElement("power_consumption");
                element.setTextContent(String.valueOf(oven.getPowerConsumption()));
                ovenElement.appendChild(element);

                element = document.createElement("weight");
                element.setTextContent(String.valueOf(oven.getWeight()));
                ovenElement.appendChild(element);

                element = document.createElement("capacity");
                element.setTextContent(String.valueOf(oven.getCapacity()));
                ovenElement.appendChild(element);

                element = document.createElement("depth");
                element.setTextContent(String.valueOf(oven.getDepth()));
                ovenElement.appendChild(element);

                element = document.createElement("height");
                element.setTextContent(String.valueOf(oven.getHeight()));
                ovenElement.appendChild(element);

                element = document.createElement("width");
                element.setTextContent(String.valueOf(oven.getWidth()));
                ovenElement.appendChild(element);

                appliancesElement.appendChild(ovenElement);
            }
        });

//        Element food = document.createElement("oven");
//        food.setAttribute("id", "234");
//
//        Element name = document.createElement("name");
//        name.setTextContent("Waffles");
//
//        food.appendChild(name);
//        breakfastMenu.appendChild(food);
        document.appendChild(appliancesElement);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new FileWriter(DB_DEST_FILE_NAME));
        transformer.transform(source, result);

    }
}
