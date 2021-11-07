package com.ccorchyts.jwd.task02.util.xmlparsing.domwriting.converation.impl;

import com.ccorchyts.jwd.task02.entity.Appliance;
import com.ccorchyts.jwd.task02.entity.builder.property.ApplianceFields;
import com.ccorchyts.jwd.task02.entity.criteria.SearchCriteria;
import com.ccorchyts.jwd.task02.entity.impl.Oven;
import com.ccorchyts.jwd.task02.util.xmlparsing.domwriting.converation.ApplianceConverter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class OvenConverterImpl implements ApplianceConverter {
    private final static String WRONG_APPLIANCE_INSTANCE = "Appliance not instance of Oven";

    @Override
    public Element createDOMElement(Appliance appliance, Document document) {
        if (!(appliance instanceof Oven)) {
            throw new RuntimeException(WRONG_APPLIANCE_INSTANCE);
        }
        Oven oven = (Oven) appliance;
        Element ovenElement = document.createElement(Oven.class.getSimpleName().toLowerCase());
        addChildToElement(ovenElement, ApplianceFields.Oven.POWER_CONSUMPTION.toString().toLowerCase(), String.valueOf(oven.getPowerConsumption()));
        addChildToElement(ovenElement, ApplianceFields.Oven.WEIGHT.toString().toLowerCase(), String.valueOf(oven.getWeight()));
        addChildToElement(ovenElement, ApplianceFields.Oven.CAPACITY.toString().toLowerCase(), String.valueOf(oven.getCapacity()));
        addChildToElement(ovenElement, ApplianceFields.Oven.DEPTH.toString().toLowerCase(), String.valueOf(oven.getDepth()));
        addChildToElement(ovenElement, ApplianceFields.Oven.HEIGHT.toString().toLowerCase(), String.valueOf(oven.getHeight()));
        addChildToElement(ovenElement, ApplianceFields.Oven.WIDTH.toString().toLowerCase(), String.valueOf(oven.getWidth()));
        return ovenElement;
    }
}
