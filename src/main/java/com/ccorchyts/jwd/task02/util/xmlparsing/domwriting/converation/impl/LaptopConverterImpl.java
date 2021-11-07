package com.ccorchyts.jwd.task02.util.xmlparsing.domwriting.converation.impl;

import com.ccorchyts.jwd.task02.entity.Appliance;
import com.ccorchyts.jwd.task02.entity.criteria.SearchCriteria;
import com.ccorchyts.jwd.task02.entity.impl.Laptop;
import com.ccorchyts.jwd.task02.util.xmlparsing.domwriting.converation.ApplianceConverter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class LaptopConverterImpl implements ApplianceConverter {
    @Override
    public Element createDOMElement(Appliance appliance, Document document) {
        if (!(appliance instanceof Laptop)) {
            throw new RuntimeException("Appliance not instance of Laptop");
        }
        Laptop laptop = (Laptop) appliance;
        Element laptopElement = document.createElement(Laptop.class.getSimpleName().toLowerCase());
        addChildToElement(laptopElement, SearchCriteria.Laptop.BATTERY_CAPACITY.toString().toLowerCase(), String.valueOf(laptop.getBatteryCapacity()));
        addChildToElement(laptopElement, SearchCriteria.Laptop.OS.toString().toLowerCase(), String.valueOf(laptop.getBatteryCapacity()));
        addChildToElement(laptopElement, SearchCriteria.Laptop.MEMORY_ROM.toString().toLowerCase(), String.valueOf(laptop.getBatteryCapacity()));
        addChildToElement(laptopElement, SearchCriteria.Laptop.SYSTEM_MEMORY.toString().toLowerCase(), String.valueOf(laptop.getBatteryCapacity()));
        addChildToElement(laptopElement, SearchCriteria.Laptop.CPU.toString().toLowerCase(), String.valueOf(laptop.getBatteryCapacity()));
        addChildToElement(laptopElement, SearchCriteria.Laptop.DISPLAY_INCHS.toString().toLowerCase(), String.valueOf(laptop.getBatteryCapacity()));
        return laptopElement;
    }
}
