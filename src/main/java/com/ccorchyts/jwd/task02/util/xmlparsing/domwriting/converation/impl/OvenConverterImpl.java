package com.ccorchyts.jwd.task02.util.xmlparsing.domwriting.converation.impl;

import com.ccorchyts.jwd.task02.entity.Appliance;
import com.ccorchyts.jwd.task02.entity.criteria.SearchCriteria;
import com.ccorchyts.jwd.task02.entity.impl.Oven;
import com.ccorchyts.jwd.task02.util.xmlparsing.domwriting.converation.ApplianceConverter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class OvenConverterImpl implements ApplianceConverter {
    @Override
    public Element createDOMElement(Appliance appliance, Document document) {
        if (!(appliance instanceof Oven)) {
            throw new RuntimeException("Appliance not instance of Laptop");
        }
        Oven oven = (Oven) appliance;
        Element ovenElement = document.createElement(Oven.class.getSimpleName().toLowerCase());
        addChildToElement(ovenElement, SearchCriteria.Oven.POWER_CONSUMPTION.toString().toLowerCase(), String.valueOf(oven.getPowerConsumption()));
        addChildToElement(ovenElement, SearchCriteria.Oven.WEIGHT.toString().toLowerCase(), String.valueOf(oven.getWeight()));
        addChildToElement(ovenElement, SearchCriteria.Oven.CAPACITY.toString().toLowerCase(), String.valueOf(oven.getCapacity()));
        addChildToElement(ovenElement, SearchCriteria.Oven.DEPTH.toString().toLowerCase(), String.valueOf(oven.getDepth()));
        addChildToElement(ovenElement, SearchCriteria.Oven.HEIGHT.toString().toLowerCase(), String.valueOf(oven.getHeight()));
        addChildToElement(ovenElement, SearchCriteria.Oven.WIDTH.toString().toLowerCase(), String.valueOf(oven.getWidth()));
        return ovenElement;
    }
}
