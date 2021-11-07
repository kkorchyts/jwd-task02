package com.ccorchyts.jwd.task02.util.xmlparsing.domwriting.converation.impl;

import com.ccorchyts.jwd.task02.entity.Appliance;
import com.ccorchyts.jwd.task02.entity.builder.property.ApplianceFields;
import com.ccorchyts.jwd.task02.entity.criteria.SearchCriteria;
import com.ccorchyts.jwd.task02.entity.impl.Refrigerator;
import com.ccorchyts.jwd.task02.util.xmlparsing.domwriting.converation.ApplianceConverter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class RefrigeratorConverterImpl implements ApplianceConverter {
    private final static String WRONG_APPLIANCE_INSTANCE = "Appliance not instance of Refrigerator";

    @Override
    public Element createDOMElement(Appliance appliance, Document document) {
        if (!(appliance instanceof Refrigerator)) {
            throw new RuntimeException(WRONG_APPLIANCE_INSTANCE);
        }
        Refrigerator refrigerator = (Refrigerator) appliance;
        Element refrigeratorElement = document.createElement(Refrigerator.class.getSimpleName().toLowerCase());
        addChildToElement(refrigeratorElement, ApplianceFields.Refrigerator.POWER_CONSUMPTION.toString().toLowerCase(), String.valueOf(refrigerator.getPowerConsumption()));
        addChildToElement(refrigeratorElement, ApplianceFields.Refrigerator.WEIGHT.toString().toLowerCase(), String.valueOf(refrigerator.getWeight()));
        addChildToElement(refrigeratorElement, ApplianceFields.Refrigerator.FREEZER_CAPACITY.toString().toLowerCase(), String.valueOf(refrigerator.getFreezerCapacity()));
        addChildToElement(refrigeratorElement, ApplianceFields.Refrigerator.OVERALL_CAPACITY.toString().toLowerCase(), String.valueOf(refrigerator.getOverallCapacity()));
        addChildToElement(refrigeratorElement, ApplianceFields.Refrigerator.HEIGHT.toString().toLowerCase(), String.valueOf(refrigerator.getHeight()));
        addChildToElement(refrigeratorElement, ApplianceFields.Refrigerator.WIDTH.toString().toLowerCase(), String.valueOf(refrigerator.getWidth()));
        return refrigeratorElement;
    }
}
