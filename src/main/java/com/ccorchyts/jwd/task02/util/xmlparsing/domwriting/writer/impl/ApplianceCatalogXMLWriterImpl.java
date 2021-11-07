package com.ccorchyts.jwd.task02.util.xmlparsing.domwriting.writer.impl;

import com.ccorchyts.jwd.task02.entity.Appliance;
import com.ccorchyts.jwd.task02.util.xmlparsing.domwriting.converation.ApplianceConverter;
import com.ccorchyts.jwd.task02.util.xmlparsing.domwriting.converation.ApplianceConverterProvider;
import com.ccorchyts.jwd.task02.util.xmlparsing.domwriting.exceptions.DOMWriteException;
import com.ccorchyts.jwd.task02.util.xmlparsing.domwriting.writer.ApplianceCatalogXMLWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static com.ccorchyts.jwd.task02.util.xmlparsing.Constant.APPLIANCE_NAMESPACE_URI;
import static com.ccorchyts.jwd.task02.util.xmlparsing.Constant.APPLIANCE_QUALIFIES_NAME;

public class ApplianceCatalogXMLWriterImpl implements ApplianceCatalogXMLWriter {

    private Document getDocumentFromFile(File file) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(file);
    }

    private Document createEmptyDocument() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.newDocument();
    }

    private void saveDocument(File file, Document document) throws TransformerException, IOException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new FileWriter(file));
        transformer.transform(source, result);
    }

    private File getFileByFileName(String fileName) {
        return new File(Objects.requireNonNull(ApplianceCatalogXMLWriterImpl.class.getClassLoader().getResource(fileName)).getFile());
    }


    private static void addSingleChildToEnd(Element element, Appliance appliance) {
        Document document = element.getOwnerDocument();
        ApplianceConverter applianceConverter = ApplianceConverterProvider.getInstance().getApplianceConverter(appliance.getClass().getSimpleName());
        Element laptopElement = applianceConverter.createDOMElement(appliance, document);
        element.appendChild(laptopElement);
        Text text = document.createTextNode("\n");
        element.appendChild(text);
    }

    @Override
    public void saveCatalogIntoXMLCatalog(File file, List<Appliance> appliances) {
        try {
            Document document = createEmptyDocument();
            Element root = document.createElementNS(APPLIANCE_NAMESPACE_URI, APPLIANCE_QUALIFIES_NAME);
            for (Appliance appliance : appliances) {
                addSingleChildToEnd(root, appliance);
            }
            saveDocument(file, document);
        } catch (ParserConfigurationException | IOException | TransformerException e) {
            throw new DOMWriteException(e);
        }
    }

    @Override
    public void saveCatalogIntoXMLCatalog(String fileName, List<Appliance> appliances) {
        saveCatalogIntoXMLCatalog(getFileByFileName(fileName), appliances);
    }

    @Override
    public void appendCatalogIntoXMLFile(File file, List<Appliance> appliances) {
        try {
            Document document = getDocumentFromFile(file);
            Element root = document.getDocumentElement();
            for (Appliance appliance : appliances) {
                addSingleChildToEnd(root, appliance);
            }
            saveDocument(file, document);
        } catch (ParserConfigurationException | IOException | SAXException | TransformerException e) {
            throw new DOMWriteException(e);
        }
    }

    @Override
    public void appendCatalogIntoXMLFile(String fileName, List<Appliance> appliances) {
        appendCatalogIntoXMLFile(getFileByFileName(fileName), appliances);

    }

    @Override
    public void appendApplianceIntoXMLCatalog(File file, Appliance appliance) {
        appendCatalogIntoXMLFile(file, Collections.singletonList(appliance));
    }

    @Override
    public void appendApplianceIntoXMLCatalog(String fileName, Appliance appliance) {
        appendApplianceIntoXMLCatalog(getFileByFileName(fileName), appliance);
    }
}
