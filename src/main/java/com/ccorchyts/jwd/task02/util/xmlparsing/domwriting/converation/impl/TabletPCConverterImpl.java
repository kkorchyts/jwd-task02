package com.ccorchyts.jwd.task02.util.xmlparsing.domwriting.converation.impl;

import com.ccorchyts.jwd.task02.entity.Appliance;
import com.ccorchyts.jwd.task02.entity.criteria.SearchCriteria;
import com.ccorchyts.jwd.task02.entity.impl.TabletPC;
import com.ccorchyts.jwd.task02.util.xmlparsing.domwriting.converation.ApplianceConverter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class TabletPCConverterImpl implements ApplianceConverter {
    @Override
    public Element createDOMElement(Appliance appliance, Document document) {
        if (!(appliance instanceof TabletPC)) {
            throw new RuntimeException("Appliance not instance of Laptop");
        }

        TabletPC tabletPC = (TabletPC) appliance;
        Element refrigeratorElement = document.createElement(TabletPC.class.getSimpleName().toLowerCase());
        addChildToElement(refrigeratorElement, SearchCriteria.TabletPC.BATTERY_CAPACITY.toString().toLowerCase(), String.valueOf(tabletPC.getBatteryCapacity()));
        addChildToElement(refrigeratorElement, SearchCriteria.TabletPC.DISPLAY_INCHES.toString().toLowerCase(), String.valueOf(tabletPC.getDisplayInches()));
        addChildToElement(refrigeratorElement, SearchCriteria.TabletPC.MEMORY_ROM.toString().toLowerCase(), String.valueOf(tabletPC.getMemoryRom()));
        addChildToElement(refrigeratorElement, SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString().toLowerCase(), String.valueOf(tabletPC.getFlashMemoryCapacity()));
        addChildToElement(refrigeratorElement, SearchCriteria.TabletPC.COLOR.toString().toLowerCase(), String.valueOf(tabletPC.getColor()));
        return refrigeratorElement;
    }
}
