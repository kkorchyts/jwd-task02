package com.kkorchyts.jwd.task02.util.xmlparsing.domwriting.converation;

import com.kkorchyts.jwd.task02.entity.Appliance;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public interface ApplianceConverter {
    Element createDOMElement(Appliance appliance, Document document);

    default void addChildToElement(Element element, String tagName, String textValue) {
        Element newElement = element.getOwnerDocument().createElement(tagName);
        newElement.setTextContent(textValue);
        element.appendChild(newElement);
    }
}
