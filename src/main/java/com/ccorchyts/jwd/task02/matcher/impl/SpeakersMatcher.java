package com.ccorchyts.jwd.task02.matcher.impl;

import com.ccorchyts.jwd.task02.entity.Appliance;
import com.ccorchyts.jwd.task02.entity.Speakers;
import com.ccorchyts.jwd.task02.entity.criteria.Criteria;
import com.ccorchyts.jwd.task02.entity.factory.ValueParser;
import com.ccorchyts.jwd.task02.matcher.ApplianceMatcher;

public class SpeakersMatcher implements ApplianceMatcher<Speakers> {
    @Override
    public Boolean matchAppliance(Appliance appliance, Criteria criteria) {
        Speakers speakers = (Speakers) appliance;
        boolean result = true;
        for (String searchCriteria : criteria.searchCriteries()) {
            switch (searchCriteria) {
                case "POWER_CONSUMPTION":
                    result = result && speakers.getPowerConsumption().equals(ValueParser.parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case "NUMBER_OF_SPEAKERS":
                    result = result && speakers.getNumberOfSpeakers().equals(ValueParser.parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case "FREQUENCY_RANGE":
                    result = result && speakers.getFrequencyRange().equals(String.valueOf(criteria.getValue(searchCriteria)));
                    break;
                case "CORD_LENGTH":
                    result = result && speakers.getCordLength().equals(ValueParser.parseFloat(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
            }
        }
        return result;
    }
}