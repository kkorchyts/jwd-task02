package com.ccorchyts.jwd.task02.util.xmlparsing.domwriting.converation.impl;

import com.ccorchyts.jwd.task02.entity.Appliance;
import com.ccorchyts.jwd.task02.entity.criteria.SearchCriteria;
import com.ccorchyts.jwd.task02.entity.impl.Speakers;
import com.ccorchyts.jwd.task02.util.xmlparsing.domwriting.converation.ApplianceConverter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class SpeakersConverterImpl implements ApplianceConverter {
    @Override
    public Element createDOMElement(Appliance appliance, Document document) {
        if (!(appliance instanceof Speakers)) {
            throw new RuntimeException("Appliance not instance of Laptop");
        }

        Speakers speakers = (Speakers) appliance;
        Element speakersElement = document.createElement(Speakers.class.getSimpleName().toLowerCase());
        addChildToElement(speakersElement, SearchCriteria.Speakers.POWER_CONSUMPTION.toString().toLowerCase(), String.valueOf(speakers.getPowerConsumption()));
        addChildToElement(speakersElement, SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString().toLowerCase(), String.valueOf(speakers.getNumberOfSpeakers()));
        addChildToElement(speakersElement, SearchCriteria.Speakers.FREQUENCY_RANGE.toString().toLowerCase(), String.valueOf(speakers.getFrequencyRange()));
        addChildToElement(speakersElement, SearchCriteria.Speakers.CORD_LENGTH.toString().toLowerCase(), String.valueOf(speakers.getCordLength()));
        return speakersElement;
    }
}
