package com.ccorchyts.jwd.task02.util.xmlparsing.domwriting.converation.impl;

import com.ccorchyts.jwd.task02.entity.Appliance;
import com.ccorchyts.jwd.task02.entity.builder.property.ApplianceFields;
import com.ccorchyts.jwd.task02.entity.criteria.SearchCriteria;
import com.ccorchyts.jwd.task02.entity.impl.Speakers;
import com.ccorchyts.jwd.task02.util.xmlparsing.domwriting.converation.ApplianceConverter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class SpeakersConverterImpl implements ApplianceConverter {
    private final static String WRONG_APPLIANCE_INSTANCE = "Appliance not instance of Speakers";

    @Override
    public Element createDOMElement(Appliance appliance, Document document) {
        if (!(appliance instanceof Speakers)) {
            throw new RuntimeException(WRONG_APPLIANCE_INSTANCE);
        }

        Speakers speakers = (Speakers) appliance;
        Element speakersElement = document.createElement(Speakers.class.getSimpleName().toLowerCase());
        addChildToElement(speakersElement, ApplianceFields.Speakers.POWER_CONSUMPTION.toString().toLowerCase(), String.valueOf(speakers.getPowerConsumption()));
        addChildToElement(speakersElement, ApplianceFields.Speakers.NUMBER_OF_SPEAKERS.toString().toLowerCase(), String.valueOf(speakers.getNumberOfSpeakers()));
        addChildToElement(speakersElement, ApplianceFields.Speakers.FREQUENCY_RANGE.toString().toLowerCase(), String.valueOf(speakers.getFrequencyRange()));
        addChildToElement(speakersElement, ApplianceFields.Speakers.CORD_LENGTH.toString().toLowerCase(), String.valueOf(speakers.getCordLength()));
        return speakersElement;
    }
}
