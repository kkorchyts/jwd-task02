package com.ccorchyts.jwd.task02.util.xmlparsing.domwriting.converation.impl;

import com.ccorchyts.jwd.task02.entity.Appliance;
import com.ccorchyts.jwd.task02.entity.criteria.SearchCriteria;
import com.ccorchyts.jwd.task02.entity.impl.Refrigerator;
import com.ccorchyts.jwd.task02.util.xmlparsing.domwriting.converation.ApplianceConverter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class RefrigeratorConverterImpl implements ApplianceConverter {
    @Override
    public Element createDOMElement(Appliance appliance, Document document) {
        if (!(appliance instanceof Refrigerator)) {
            throw new RuntimeException("Appliance not instance of Laptop");
        }
        Refrigerator refrigerator = (Refrigerator) appliance;
        Element refrigeratorElement = document.createElement(Refrigerator.class.getSimpleName().toLowerCase());
        addChildToElement(refrigeratorElement, SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString().toLowerCase(), String.valueOf(refrigerator.getPowerConsumption()));
        addChildToElement(refrigeratorElement, SearchCriteria.Refrigerator.WEIGHT.toString().toLowerCase(), String.valueOf(refrigerator.getWeight()));
        addChildToElement(refrigeratorElement, SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString().toLowerCase(), String.valueOf(refrigerator.getFreezerCapacity()));
        addChildToElement(refrigeratorElement, SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString().toLowerCase(), String.valueOf(refrigerator.getOverallCapacity()));
        addChildToElement(refrigeratorElement, SearchCriteria.Refrigerator.HEIGHT.toString().toLowerCase(), String.valueOf(refrigerator.getHeight()));
        addChildToElement(refrigeratorElement, SearchCriteria.Refrigerator.WIDTH.toString().toLowerCase(), String.valueOf(refrigerator.getWidth()));
        return refrigeratorElement;
    }
}
