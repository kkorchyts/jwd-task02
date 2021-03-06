package com.kkorchyts.jwd.task02.service.validation.impl;

import com.kkorchyts.jwd.task02.entity.criteria.SearchCriteria;
import com.kkorchyts.jwd.task02.service.validation.CriteriaValidator;
import com.kkorchyts.jwd.task02.util.numberparsing.ValueParser;

import java.util.Objects;

public class SpeakersCriteriaValidator extends BaseCriteriaValidator implements CriteriaValidator {
    {
        parameterValidators.put(SearchCriteria.Speakers.POWER_CONSUMPTION.toString(), value -> {
            Integer integerValue = ValueParser.parseInteger(String.valueOf(value));
            return integerValue > 0 && integerValue < 100;
        });

        parameterValidators.put(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString(), value -> {
            Integer integerValue = ValueParser.parseInteger(String.valueOf(value));
            return integerValue > 0 && integerValue < 11;
        });

        parameterValidators.put(SearchCriteria.Speakers.FREQUENCY_RANGE.toString(), Objects::nonNull);

        parameterValidators.put(SearchCriteria.Speakers.CORD_LENGTH.toString(), value -> {
            Float floatValue = ValueParser.parseFloat(String.valueOf(value));
            return floatValue > 2 && floatValue < 40;
        });
    }
}