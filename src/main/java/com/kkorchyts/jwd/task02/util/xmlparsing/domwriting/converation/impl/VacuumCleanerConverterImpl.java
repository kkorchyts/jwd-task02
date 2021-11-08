package com.kkorchyts.jwd.task02.util.xmlparsing.domwriting.converation.impl;

import com.kkorchyts.jwd.task02.entity.Appliance;
import com.kkorchyts.jwd.task02.entity.builder.property.ApplianceFields;
import com.kkorchyts.jwd.task02.entity.impl.VacuumCleaner;
import com.kkorchyts.jwd.task02.util.xmlparsing.domwriting.converation.ApplianceConverter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class VacuumCleanerConverterImpl implements ApplianceConverter {
    private final static String WRONG_APPLIANCE_INSTANCE = "Appliance not instance of VacuumCleaner";

    @Override
    public Element createDOMElement(Appliance appliance, Document document) {
        if (!(appliance instanceof VacuumCleaner)) {
            throw new RuntimeException(WRONG_APPLIANCE_INSTANCE);
        }

        VacuumCleaner vacuumCleaner = (VacuumCleaner) appliance;
        Element refrigeratorElement = document.createElement(VacuumCleaner.class.getSimpleName().toLowerCase());
        addChildToElement(refrigeratorElement, ApplianceFields.VacuumCleaner.POWER_CONSUMPTION.toString().toLowerCase(), String.valueOf(vacuumCleaner.getPowerConsumption()));
        addChildToElement(refrigeratorElement, ApplianceFields.VacuumCleaner.FILTER_TYPE.toString().toLowerCase(), String.valueOf(vacuumCleaner.getFilterType()));
        addChildToElement(refrigeratorElement, ApplianceFields.VacuumCleaner.BAG_TYPE.toString().toLowerCase(), String.valueOf(vacuumCleaner.getBagType()));
        addChildToElement(refrigeratorElement, ApplianceFields.VacuumCleaner.WAND_TYPE.toString().toLowerCase(), String.valueOf(vacuumCleaner.getWandType()));
        addChildToElement(refrigeratorElement, ApplianceFields.VacuumCleaner.MOTOR_SPEED_REGULATION.toString().toLowerCase(), String.valueOf(vacuumCleaner.getMotorSpeedRegulation()));
        addChildToElement(refrigeratorElement, ApplianceFields.VacuumCleaner.CLEANING_WIDTH.toString().toLowerCase(), String.valueOf(vacuumCleaner.getCleaningWidth()));
        return refrigeratorElement;
    }
}
