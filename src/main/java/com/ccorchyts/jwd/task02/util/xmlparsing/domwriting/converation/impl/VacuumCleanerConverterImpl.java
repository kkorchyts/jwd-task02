package com.ccorchyts.jwd.task02.util.xmlparsing.domwriting.converation.impl;

import com.ccorchyts.jwd.task02.entity.Appliance;
import com.ccorchyts.jwd.task02.entity.criteria.SearchCriteria;
import com.ccorchyts.jwd.task02.entity.impl.VacuumCleaner;
import com.ccorchyts.jwd.task02.util.xmlparsing.domwriting.converation.ApplianceConverter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class VacuumCleanerConverterImpl implements ApplianceConverter {
    @Override
    public Element createDOMElement(Appliance appliance, Document document) {
        if (!(appliance instanceof VacuumCleaner)) {
            throw new RuntimeException("Appliance not instance of Laptop");
        }

        VacuumCleaner vacuumCleaner = (VacuumCleaner) appliance;
        Element refrigeratorElement = document.createElement(VacuumCleaner.class.getSimpleName().toLowerCase());
        addChildToElement(refrigeratorElement, SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString().toLowerCase(), String.valueOf(vacuumCleaner.getPowerConsumption()));
        addChildToElement(refrigeratorElement, SearchCriteria.VacuumCleaner.FILTER_TYPE.toString().toLowerCase(), String.valueOf(vacuumCleaner.getFilterType()));
        addChildToElement(refrigeratorElement, SearchCriteria.VacuumCleaner.BAG_TYPE.toString().toLowerCase(), String.valueOf(vacuumCleaner.getBagType()));
        addChildToElement(refrigeratorElement, SearchCriteria.VacuumCleaner.WAND_TYPE.toString().toLowerCase(), String.valueOf(vacuumCleaner.getWandType()));
        addChildToElement(refrigeratorElement, SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString().toLowerCase(), String.valueOf(vacuumCleaner.getMotorSpeedRegulation()));
        addChildToElement(refrigeratorElement, SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString().toLowerCase(), String.valueOf(vacuumCleaner.getCleaningWidth()));
        return refrigeratorElement;
    }
}
