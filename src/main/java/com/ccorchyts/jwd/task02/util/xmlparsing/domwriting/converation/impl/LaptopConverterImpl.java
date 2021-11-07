package com.ccorchyts.jwd.task02.util.xmlparsing.domwriting.converation.impl;

import com.ccorchyts.jwd.task02.entity.Appliance;
import com.ccorchyts.jwd.task02.entity.builder.property.ApplianceFields;
import com.ccorchyts.jwd.task02.entity.criteria.SearchCriteria;
import com.ccorchyts.jwd.task02.entity.impl.Laptop;
import com.ccorchyts.jwd.task02.util.xmlparsing.domwriting.converation.ApplianceConverter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class LaptopConverterImpl implements ApplianceConverter {
    private final static String WRONG_APPLIANCE_INSTANCE = "Appliance not instance of Laptop";

    @Override
    public Element createDOMElement(Appliance appliance, Document document) {
        if (!(appliance instanceof Laptop)) {
            throw new RuntimeException(WRONG_APPLIANCE_INSTANCE);
        }
        Laptop laptop = (Laptop) appliance;
        Element laptopElement = document.createElement(Laptop.class.getSimpleName().toLowerCase());
        addChildToElement(laptopElement, ApplianceFields.Laptop.BATTERY_CAPACITY.toString().toLowerCase(), String.valueOf(laptop.getBatteryCapacity()));
        addChildToElement(laptopElement, ApplianceFields.Laptop.OS.toString().toLowerCase(), String.valueOf(laptop.getBatteryCapacity()));
        addChildToElement(laptopElement, ApplianceFields.Laptop.MEMORY_ROM.toString().toLowerCase(), String.valueOf(laptop.getBatteryCapacity()));
        addChildToElement(laptopElement, ApplianceFields.Laptop.SYSTEM_MEMORY.toString().toLowerCase(), String.valueOf(laptop.getBatteryCapacity()));
        addChildToElement(laptopElement, ApplianceFields.Laptop.CPU.toString().toLowerCase(), String.valueOf(laptop.getBatteryCapacity()));
        addChildToElement(laptopElement, ApplianceFields.Laptop.DISPLAY_INCHS.toString().toLowerCase(), String.valueOf(laptop.getBatteryCapacity()));
        return laptopElement;
    }
}
